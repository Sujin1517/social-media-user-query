package com.example.user.query.controller;

import com.example.user.query.exception.NotFoundException;
import com.example.user.query.exception.NotMatchException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFoundException(NotFoundException e) {
        return e.getMessage() + " IS NOT FOUND";
    }

    @ExceptionHandler(NotMatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String notMatchException(NotMatchException e) {
        return e.getMessage() + "IS NOT MATCH";
    }
}