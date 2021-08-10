package com.example.appmortgage.validation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;


@ControllerAdvice
public class ExceptionHelper {
    @ExceptionHandler(value = {ConstraintViolationException.class})
    public ResponseEntity<Object> handleInvalidInputException(ConstraintViolationException ex) {
        String[] messages = ex.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .toArray(String[]::new);
        return new ResponseEntity<>(messages, HttpStatus.BAD_REQUEST);
    }
}
