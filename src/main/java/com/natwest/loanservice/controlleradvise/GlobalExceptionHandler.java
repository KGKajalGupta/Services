package com.natwest.loanservice.controlleradvise;

import com.natwest.loanservice.exceptions.IdAlreadyExistException;
import com.natwest.loanservice.exceptions.NotEligibleForLoanException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IdAlreadyExistException.class)
    public ResponseEntity<ErrorInfo> handleExceptionForIdNotFound(IdAlreadyExistException exception){
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setErrorMessage(exception.getMessage());
        errorInfo.setHttpStatus(HttpStatus.BAD_REQUEST);
        errorInfo.setLocalDateTime(LocalDateTime.now());

        return new ResponseEntity<>(errorInfo, HttpStatus.OK);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorInfo> handleExceptionForIllegalArgumentException(IllegalArgumentException exception){
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setErrorMessage(exception.getMessage());
        errorInfo.setHttpStatus(HttpStatus.BAD_REQUEST);
        errorInfo.setLocalDateTime(LocalDateTime.now());

        return new ResponseEntity<>(errorInfo, HttpStatus.OK);
    }

    @ExceptionHandler(NotEligibleForLoanException.class)
    public ResponseEntity<ErrorInfo> handleExceptionForNotEligibleForLoanException(NotEligibleForLoanException exception){
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setErrorMessage(exception.getMessage());
        errorInfo.setHttpStatus(HttpStatus.BAD_REQUEST);
        errorInfo.setLocalDateTime(LocalDateTime.now());

        return new ResponseEntity<>(errorInfo, HttpStatus.OK);
    }
}
