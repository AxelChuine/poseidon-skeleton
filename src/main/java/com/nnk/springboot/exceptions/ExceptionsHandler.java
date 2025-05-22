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

    @ExceptionHandler(BidListNotFoundException.class)
    public ResponseEntity<String> handleBidListNotFoundException(final BidListNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), e.getCode());
    }

    @ExceptionHandler(CurvePointIsNullException.class)
    public ResponseEntity<String> handleCurvePointIsNullException(final CurvePointIsNullException e) {
        return new ResponseEntity<>(e.getMessage(), e.getCode());
    }

    @ExceptionHandler(CurvePointNotFoundException.class)
    public ResponseEntity<String> handleCurvePointNotFoundException(final CurvePointNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), e.getCode());
    }

    @ExceptionHandler(UserListIsEmptyException.class)
    public ResponseEntity<String> handleUserListIsEmptyException(final UserListIsEmptyException e) {
        return new ResponseEntity<>(e.getMessage(), e.getCode());
    }
}
