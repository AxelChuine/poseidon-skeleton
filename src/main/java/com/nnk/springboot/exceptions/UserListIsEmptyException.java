package com.nnk.springboot.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserListIsEmptyException extends Exception {
    private String message;
    private HttpStatus code;

    public UserListIsEmptyException() {
        super();
        this.message = "La liste d'utilisateur est vide.";
        this.code = HttpStatus.NOT_FOUND;
    }

    public UserListIsEmptyException(String message) {
        super(message);
        this.message = message;
    }
}
