package com.natwest.loanservice.exceptions;

public class IdAlreadyExistException extends Exception{

    private String message;

    public IdAlreadyExistException(String message) {
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
