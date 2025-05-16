package com.nnk.springboot.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BidListNotFoundException extends Exception {
    private String message;
    private final HttpStatus code = HttpStatus.NOT_FOUND;

    public BidListNotFoundException() {
        super();
        this.message = "bid list not found";
    }

    public BidListNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
