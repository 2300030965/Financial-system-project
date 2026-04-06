package com.klef.fsad.service.customer;

import com.klef.fsad.entity.Loan;
import com.klef.fsad.entity.LoanPayment;

import java.util.List;
import java.util.Map;

public interface CustomerLoanService {

    Loan applyLoan(String email, Loan loan);

    List<Loan> getMyLoans(String email);

    List<Loan> filterLoans(
            String email,
            String type,
            String category,
            String startDate,
            String endDate
    );

    LoanPayment payLoan(String email, Long loanId, double amount);

    Map<String, Object> getLoanStatus(String email);

    List<LoanPayment> getLoanPayments(Long loanId);
}