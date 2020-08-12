package com.exalt.usecase.exception;

import org.springframework.http.HttpStatus;

public enum EnumError {
    EXIST_EMAIL("Email already exist", HttpStatus.CONFLICT),
    USEER_NOT_FOUND("USER NOT FOUND!",HttpStatus.NOT_FOUND);

    private String message;

    private HttpStatus status;

    EnumError(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
