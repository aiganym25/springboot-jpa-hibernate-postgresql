package com.aiganym.userapp.springbootjpahibernatepostgresql.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UserNoContentException.class)

    public ResponseEntity<?>  handleUserNoContentException (UserNoContentException ex) {

        HttpStatus noContent = HttpStatus.NO_CONTENT;
        ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), noContent, new Date());
        return new ResponseEntity<>(errorDetails, noContent);
    }


    @ExceptionHandler(UserNotFoundException.class)

    public ResponseEntity<?>  handleUserNotFoundException (UserNotFoundException ex) {

        HttpStatus notFound = HttpStatus.NOT_FOUND;
        ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), notFound, new Date());
        return new ResponseEntity<>(errorDetails, notFound);
    }


}

