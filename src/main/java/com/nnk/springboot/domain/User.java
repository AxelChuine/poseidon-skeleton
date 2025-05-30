package com.nnk.springboot.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users", schema = "demo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "username", length = 125)
    private String username;

    @Column(name = "password", length = 125)
    private String password;

    @Column(name = "fullname", length = 125)
    private String fullname;

    @Column(name = "role", length = 125)
    private String role;

    public User(String fullName, String username, String password) {
        this.username = username;
        this.password = password;
        this.fullname = fullName;
        this.role = "USER";
    }

    public User(String username, String fullName, String password, String role) {
        this.username = username;
        this.fullname = fullName;
        this.password = password;
        this.role = role;
    }
}
