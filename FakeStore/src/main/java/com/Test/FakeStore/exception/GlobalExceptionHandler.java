package com.Test.FakeStore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String, Object>>
    handleProductNotFoundException(
            ProductNotFoundException ex){
        Map<String,Object> response = new HashMap<>();
        response.put("message",ex.getMessage());
        response.put("status",404);

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
