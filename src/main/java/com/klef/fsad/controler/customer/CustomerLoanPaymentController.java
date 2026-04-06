package com.klef.fsad.controler.customer;

import com.klef.fsad.entity.LoanPayment;
import com.klef.fsad.service.customer.CustomerLoanPaymentService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer/loan-payments")
public class CustomerLoanPaymentController {

    private final CustomerLoanPaymentService service;

    public CustomerLoanPaymentController(CustomerLoanPaymentService service) {
        this.service = service;
    }

    // 🔥 PAY LOAN (EMI)
    @PostMapping("/pay")
    public LoanPayment payLoan(Authentication auth,
                               @RequestParam Long loanId,
                               @RequestParam double amount) {

        return service.payLoan(auth.getName(), loanId, amount);
    }
}