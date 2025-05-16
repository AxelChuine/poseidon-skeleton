package com.nnk.springboot.exceptions;


import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserNotFoundException extends Exception {
    private String message;
    private final HttpStatus code = HttpStatus.NOT_FOUND;

    public UserNotFoundException() {
        super();
        this.message = "User not found";
    }

    public UserNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
