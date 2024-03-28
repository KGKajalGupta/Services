package com.natwest.loanservice.services;

import com.natwest.loanservice.entity.Loan;
import com.natwest.loanservice.exceptions.IdAlreadyExistException;
import com.natwest.loanservice.exceptions.NotEligibleForLoanException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoanService {
    Loan addLoan(Loan loan) throws IdAlreadyExistException;
    List<Loan> getAllLoanDetails();
    Loan findById(int id);
    List<Loan> findByAmount(Double loanAmount);
    public List<Loan> findLoanInfo(String loanType, int accountNumber) throws NotEligibleForLoanException;
}
