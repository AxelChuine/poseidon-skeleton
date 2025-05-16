package com.nnk.springboot.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ParameterNotProvidedException extends Exception{
    private String message;
    private final HttpStatus code = HttpStatus.NOT_ACCEPTABLE;

    public ParameterNotProvidedException() {
        super();
        this.message = "Parameter not provided";
    }

    public ParameterNotProvidedException(String message) {
        super(message);
        this.message = message;
    }
}
