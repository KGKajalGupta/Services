package com.natwest.loanservice.repositories;

import com.natwest.loanservice.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {
    List<Loan> findAllByLoanAmount(Double loanAmount);
    List<Loan> findByLoanType(String loanType);
}
