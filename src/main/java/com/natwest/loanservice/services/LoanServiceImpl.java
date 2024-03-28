package com.natwest.loanservice.services;

import com.currency.CurrencyConversionService;
import com.natwest.loanservice.entity.Loan;
import com.natwest.loanservice.exceptions.IdAlreadyExistException;
import com.natwest.loanservice.exceptions.NotEligibleForLoanException;
import com.natwest.loanservice.repositories.LoanRepository;
import com.natwest.loanservice.utility.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.utility.Customer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoanServiceImpl implements LoanService{

    @Autowired
    LoanRepository loanRepository;
    private List<Customer> accounts = new ArrayList<>();

    public List<Customer> getCustomers(){
        return accounts;
    }


    private String getCountryWithCurrency(String country){
        Map<String, String> countryCurrencyMap = new HashMap<>();

        countryCurrencyMap.put("India", "INR");
        countryCurrencyMap.put("United States", "USD");
        countryCurrencyMap.put("United Kingdom", "GBP");
        countryCurrencyMap.put("Australia", "AUD");
        countryCurrencyMap.put("Canada", "CAD");
        countryCurrencyMap.put("European Union", "EUR");
        countryCurrencyMap.put("Japan", "JPY");
        countryCurrencyMap.put("Switzerland", "CHF");
        countryCurrencyMap.put("China", "CNY");
        countryCurrencyMap.put("Brazil", "BRL");
        countryCurrencyMap.put("Russia", "RUB");
        countryCurrencyMap.put("South Africa", "ZAR)");
        countryCurrencyMap.put("Mexico", "MXN");
        countryCurrencyMap.put("New Zealand", "NZD");
        countryCurrencyMap.put("Singapore", "SGD");

        return countryCurrencyMap.get(country);
    }

    public void addCustomer(Customer customer){
        accounts.add(customer);
    }

    @Override
    public Loan addLoan(Loan loan) throws IdAlreadyExistException {
        if (loanRepository.existsById(loan.getLoanId())){
            throw new IdAlreadyExistException(AppConstant.ID_NOT_FOUND_MESSAGE);
        }
        return loanRepository.save(loan);
    }

    @Override
    public List<Loan> getAllLoanDetails() {
        return loanRepository.findAll();
    }

    @Override
    public Loan findById(int id) {
        return loanRepository.findById(id).get();
    }

    @Override
    public List<Loan> findByAmount(Double loanAmount) {
        return loanRepository.findAllByLoanAmount(loanAmount);
    }

    public List<Loan> findByLoanType(String loanType){
        return loanRepository.findByLoanType(loanType);
    }

    @Override
    public List<Loan> findLoanInfo(String loanType, int accountNumber) throws NotEligibleForLoanException {
        Customer customer = null;
        for (Customer c: accounts){
            if (c.getAccount().getAccountNumber()==accountNumber){
                customer = c;
            }
        }

        if (customer.getAccount().getBalance().compareTo(BigDecimal.valueOf(620))>0 && customer.getOccupation()!="Criminal" && customer.getAge()>18){
            if (!customer.getCountry().equals("India")){
                List<Loan> loans = findByLoanType(loanType);
                String currency = getCountryWithCurrency(customer.getCountry());

                for (int i=0; i< loans.size(); i++){
                    double loanAmount = loans.get(i).getLoanAmount();
                    CurrencyConversionService ccs = new CurrencyConversionService();
                    double balance = ccs.convertCurrency("INR", loanAmount, currency);
                    customer.getAccount().setBalance(BigDecimal.valueOf(balance));

                }
            }
            return findByLoanType(loanType);
        }
        throw new NotEligibleForLoanException(AppConstant.NOT_ELIGIBLE_FOR_LOAN);
    }

    public List<Loan> getLoan(Long id){
        return null;
    }
}
