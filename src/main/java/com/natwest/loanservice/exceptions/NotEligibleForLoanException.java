package com.natwest.loanservice.exceptions;

public class NotEligibleForLoanException extends Exception{
    private String message;

    public NotEligibleForLoanException(String message) {
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
