package com.example.user.query.exception;

public class NotFoundException extends IllegalArgumentException{
    public NotFoundException(String msg){
        super(msg);
    }
}