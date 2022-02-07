package com.test.controller;

import com.test.exception.ResourceAlreadyExistsException;
import com.test.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionManger {

    @ExceptionHandler
    public ResponseEntity notFound(ResourceNotFoundException e){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler
    public ResponseEntity alreadyExists(ResourceAlreadyExistsException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity alreadyExists(IllegalArgumentException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
    @ExceptionHandler
    public ResponseEntity allOther(RuntimeException e){
        return ResponseEntity.internalServerError().body("Oops!! Something went wrong...");
    }
}
