package com.nnk.springboot.configuration;

import com.nnk.springboot.security.CustomAuthenticationSuccessHandler;
import com.nnk.springboot.security.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    private final CustomUserDetailsService customUserDetailsService;

    public SecurityConfiguration(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder(12);
    }


    /**
     * Authorize every page to a normal user but only allow admins to access the user/list page
     *
     * Create the default login page but use a custom authentication success handler to redirect to the correct page
     * @param http
     * @return SecurityFilterChain
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> {
                        auth.requestMatchers("/css/*").permitAll();
                        auth.requestMatchers("/").permitAll();
                        auth.requestMatchers("/login").permitAll();
                        auth.requestMatchers("../static/*").permitAll();
                        auth.requestMatchers("/app/login").permitAll();
                        auth.requestMatchers("/bidList/*").authenticated();
                        auth.requestMatchers("/curvePoint/*").authenticated();
                        auth.requestMatchers("/user/*").hasRole("ADMIN").anyRequest().authenticated();
                    }
                )
                .formLogin(
                        formLogin ->
                                formLogin.successHandler(customAuthenticationSuccessHandler())
                )
                .build();
    }

    @Bean
    public AuthenticationSuccessHandler customAuthenticationSuccessHandler() {
        return new CustomAuthenticationSuccessHandler();
    }
}
