package com.aiganym.userapp.springbootjpahibernatepostgresql.exception;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ErrorDetails {

    private String message;
    private HttpStatus httpStatus;
    private Date time;

    public ErrorDetails(String message, HttpStatus httpStatus, Date time) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}

