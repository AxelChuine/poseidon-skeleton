package com.nnk.springboot.security;

import com.nnk.springboot.dtos.UserDto;
import com.nnk.springboot.services.impl.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    /**
     * @param username 
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto dto = this.userService.findByUsername(username);
        if (dto == null) {
            throw new UsernameNotFoundException("The user with the " + username + " was not found");
        }
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + dto.getRole().toString());
        return new User(dto.getUsername(), dto.getPassword(), List.of(authority));
    }
}
