package com.nnk.springboot.dtos;

import com.nnk.springboot.domain.enums.Role;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Integer id;

    @NotNull
    private String username;

    @NotNull
    private String fullname;

    @Size(min = 8)
    @Pattern(regexp = "/(.*[aA-zZ])(.*[@!%$&^£])(.*[0-9])/gm.{8,}$",
            message = "Le mot de passe doit contenir au moins 8 caractères, une majuscule, un chiffre et un caractère spécial.")
    @NotNull
    private String password;

    @NotNull
    private Role role;

    public UserDto(String username, String fullName, String password) {
        this.username = username;
        this.fullname = fullName;
        this.password = password;
    }

    public UserDto(String username, String fullName, String password, Role role) {
        this.username = username;
        this.fullname = fullName;
        this.password = password;
        this.role = role;
    }
}
