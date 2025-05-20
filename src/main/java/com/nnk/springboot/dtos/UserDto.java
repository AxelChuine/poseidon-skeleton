package com.nnk.springboot.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Integer id;
    private String username;
    private String fullname;
    private String password;
    private String role;

    public UserDto(String username, String fullName, String password) {
        this.username = username;
        this.fullname = fullName;
        this.password = password;
    }

    public UserDto(String username, String fullName, String password, String role) {
        this.username = username;
        this.fullname = fullName;
        this.password = password;
        this.role = role;
    }
}
