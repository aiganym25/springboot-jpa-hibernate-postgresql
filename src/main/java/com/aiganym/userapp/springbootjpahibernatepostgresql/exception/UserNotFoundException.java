package com.aiganym.userapp.springbootjpahibernatepostgresql.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message) {
        super(message);
    }
}
