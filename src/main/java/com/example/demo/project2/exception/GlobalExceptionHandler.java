package com.example.demo.project2.exception;

import com.example.demo.project2.exception.RequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RequestException.class)
    public ResponseEntity<String> handleRequestException(RequestException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(value = INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleException(ProcessFailedException exception) {
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(exception.getMessage());
    }
}
