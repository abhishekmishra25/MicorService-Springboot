package org.lcwd.rating.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Objects>> handleRatingNotFoundException(ResourceNotFoundException ex) {
        Map res =   new HashMap<>();
        res.put("message", ex.getMessage());
        res.put("success", false);
        res.put("status", HttpStatus.NOT_FOUND);
        return new ResponseEntity<Map<String, Objects>>(res, HttpStatus.NOT_FOUND);
    }
}
