package com.nnk.springboot.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class IncorrectPasswordException extends Exception {
    private final String message = "Le mot de passe ne contient pas 8 caractères et / ou ne contient pas au moins un chiffre et un symbole";
    private final HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
}
