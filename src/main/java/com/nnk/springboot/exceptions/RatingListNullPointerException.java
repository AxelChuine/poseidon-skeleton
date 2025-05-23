package com.nnk.springboot.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class RatingListNullPointerException extends NullPointerException {
    private String message;
    private final HttpStatus code = HttpStatus.NO_CONTENT;

    public RatingListNullPointerException() {
        super();
        this.message = "Rating list is null";
    }

    public RatingListNullPointerException(String message) {
        super(message);
        this.message = message;
    }
}
