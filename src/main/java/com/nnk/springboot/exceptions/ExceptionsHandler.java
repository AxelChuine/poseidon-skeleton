package com.nnk.springboot.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(ParameterNotProvidedException.class)
    public ResponseEntity<String> handleParameterNotProvidedException(final ParameterNotProvidedException e) {
        return new ResponseEntity<>(e.getMessage(), e.getCode());
    }
}
