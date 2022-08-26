package com.example.herokudemo.exception;

public class PaperNotFoundException extends RuntimeException{

    public PaperNotFoundException(String message) {
        super(message);
    }

    public PaperNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
