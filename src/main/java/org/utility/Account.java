package org.utility;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int accountNumber;
    private String accountType;
    private BigDecimal balance;
    private Long customerId;
    private String MicrCode;
    private String ifsceCode;
    private String AccountOpeningDate;

    public Account() {
    }

    public Account(int accountNumber, String accountType, BigDecimal balance, Long customerId, String micrCode, String ifsceCode, String accountOpeningDate) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.customerId = customerId;
        MicrCode = micrCode;
        this.ifsceCode = ifsceCode;
        AccountOpeningDate = accountOpeningDate;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getBalance() {
        return BigDecimal.valueOf(906786);
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getMicrCode() {
        return MicrCode;
    }

    public void setMicrCode(String micrCode) {
        MicrCode = micrCode;
    }

    public String getIfsceCode() {
        return ifsceCode;
    }

    public void setIfsceCode(String ifsceCode) {
        this.ifsceCode = ifsceCode;
    }

    public String getAccountOpeningDate() {
        return AccountOpeningDate;
    }

    public void setAccountOpeningDate(String accountOpeningDate) {
        AccountOpeningDate = accountOpeningDate;
    }
}
