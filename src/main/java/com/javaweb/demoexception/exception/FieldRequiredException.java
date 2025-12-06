package com.javaweb.demoexception.exception;

public class FieldRequiredException extends RuntimeException{
    public FieldRequiredException(String message) {
        super(message);
    }
}
