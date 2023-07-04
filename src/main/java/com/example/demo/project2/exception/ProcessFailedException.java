package com.example.demo.project2.exception;


public class ProcessFailedException extends Exception {
    public ProcessFailedException(Exception e) {
        super(e);
    }

    public ProcessFailedException(String message) {
        super(message);
    }
}

