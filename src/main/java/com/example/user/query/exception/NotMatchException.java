package com.example.user.query.exception;

public class NotMatchException extends IllegalArgumentException{
    public NotMatchException(String msg){
        super(msg);
    }
}
