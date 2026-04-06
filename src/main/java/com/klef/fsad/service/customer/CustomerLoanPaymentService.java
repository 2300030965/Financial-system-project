package com.klef.fsad.service.customer;

import com.klef.fsad.entity.LoanPayment;

public interface CustomerLoanPaymentService {

    LoanPayment payLoan(String email, Long loanId, double amount);
}