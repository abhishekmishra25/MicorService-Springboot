package org.lcwd.user.service.exceptions;

import org.lcwd.user.service.payload.ApiResonse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResonse> handleUserNotFoundException(ResourceNotFoundException ex) {
        ApiResonse res =   ApiResonse.builder().message(ex.getMessage()).success(true).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<ApiResonse>(res, HttpStatus.NOT_FOUND);
    }
}
