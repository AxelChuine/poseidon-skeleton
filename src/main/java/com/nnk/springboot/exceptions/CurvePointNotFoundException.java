package com.nnk.springboot.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CurvePointNotFoundException extends Exception {
    private String message;
    private final HttpStatus code = HttpStatus.NOT_FOUND;

    public CurvePointNotFoundException() {
        super();
        this.message = "Curve point not found";
    }

    public CurvePointNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
