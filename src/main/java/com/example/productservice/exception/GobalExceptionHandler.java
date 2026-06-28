package com.example.productservice.exception;

import com.example.productservice.dto.ErrorResponse;
import com.example.productservice.exception.dto.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> productNotFoundExceptionHandler(ProductNotFoundException ex){
        ErrorResponse response=new ErrorResponse(Timestamp.valueOf(LocalDateTime.now()),"Product not found ");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }
}
