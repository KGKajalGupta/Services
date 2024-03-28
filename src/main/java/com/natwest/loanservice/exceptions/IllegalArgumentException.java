package com.natwest.loanservice.exceptions;

public class IllegalArgumentException extends Exception{
    private String message;

    public IllegalArgumentException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
