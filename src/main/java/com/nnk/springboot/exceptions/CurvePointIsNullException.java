package com.nnk.springboot.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CurvePointIsNullException extends Exception {
    private String message;
    private final HttpStatus code = HttpStatus.NOT_ACCEPTABLE;

    public CurvePointIsNullException() {
        super();
        this.message = "Curve point is null";
    }

    public CurvePointIsNullException(String message) {
        super(message);
        this.message = message;
    }
}
