package com.natwest.loanservice.controller;

import com.natwest.loanservice.entity.Loan;
import com.natwest.loanservice.exceptions.IdAlreadyExistException;
import com.natwest.loanservice.exceptions.NotEligibleForLoanException;
import com.natwest.loanservice.services.LoanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.utility.Customer;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class LoanController {

    @Autowired
    LoanServiceImpl loanService;

    @PostMapping("loan")
    public Loan addLoan(@RequestBody Loan loan) throws IdAlreadyExistException {
        return loanService.addLoan(loan);
    }

    @GetMapping("loanInfo/{loanType}/{accountNumber}")
    public List<Loan> displayAvailableLoan(@PathVariable String loanType, @PathVariable int accountNumber) throws NotEligibleForLoanException {
        return loanService.findLoanInfo(loanType, accountNumber);
    }

    @GetMapping("accounts")
    public List<Customer> getAllCustomers(){
        return loanService.getCustomers();
    }

    @GetMapping("account/{type}")
    public List<Loan> getLoanByType(@PathVariable String type){
        return loanService.findByLoanType(type);
    }

    @PostMapping("account")
    public String addAccount(@RequestBody Customer customer){
        loanService.addCustomer(customer);
        return "account added";
    }

    @GetMapping("customers")
    public List<Loan> getLoans(){
        return loanService.getAllLoanDetails();
    }
}
