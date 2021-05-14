package com.aiganym.userapp.springbootjpahibernatepostgresql.exception;

public class UserNoContentException extends RuntimeException{
    public UserNoContentException(String message) {
        super(message);
    }
}
