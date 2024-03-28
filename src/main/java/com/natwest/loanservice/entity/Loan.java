package com.natwest.loanservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Loans Details")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int loanId;
    private double loanAmount;
    private int duration;
    private String loanType;
    private double loanInterestRate;
    private int EMI_Amount;
    private String status;

    public Loan() {
    }

    public Loan(int loanId, double loanAmount, int duration, String loanType, double loanInterestRate, int numberOfPayment, String status) {
        this.loanId = loanId;
        this.loanAmount = loanAmount;
        this.duration = duration;
        this.loanType = loanType;
        this.loanInterestRate = loanInterestRate;
        this.EMI_Amount = numberOfPayment;
        this.status = status;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public double getLoanInterestRate() {
        return loanInterestRate;
    }

    public void setLoanInterestRate(double loanInterestRate) {
        this.loanInterestRate = loanInterestRate;
    }

    public int getEMI_Amount() {
        return EMI_Amount;
    }

    public void setEMI_Amount(int EMI_Amount) {
        this.EMI_Amount = EMI_Amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanId='" + loanId + '\'' +
                ", loanAmount=" + loanAmount +
                ", duration=" + duration +
                ", loanType='" + loanType + '\'' +
                ", loanInterestRate=" + loanInterestRate +
                '}';
    }
}
