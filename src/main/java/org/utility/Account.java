package org.utility;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor

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

    public BigDecimal getBalance(){
        return BigDecimal.valueOf(56000.00);
    }
}
