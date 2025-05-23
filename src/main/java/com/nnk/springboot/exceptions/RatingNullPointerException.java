package com.nnk.springboot.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class RatingNullPointerException extends NullPointerException {
    private String message;
    private HttpStatus code;

    public RatingNullPointerException() {
        super();
        this.message = "Rating is null";
        code = HttpStatus.NOT_ACCEPTABLE;
    }

    public RatingNullPointerException(String message) {
        super(message);
        this.message = message;
        code = HttpStatus.NOT_ACCEPTABLE;
    }

    public RatingNullPointerException(String message, HttpStatus code) {
        super(message);
        this.message = message;
        this.code = code;
    }
}
