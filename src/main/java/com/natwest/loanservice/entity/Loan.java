package com.natwest.loanservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Loans Details")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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

}
