package com.klef.fsad.controler.customer;

import com.klef.fsad.entity.Loan;
import com.klef.fsad.service.customer.CustomerLoanService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer/loans")
public class CustomerLoanController {

    private final CustomerLoanService service;

    public CustomerLoanController(CustomerLoanService service) {
        this.service = service;
    }

    // Apply loan
    @PostMapping
    public Loan applyLoan(Authentication auth, @RequestBody Loan loan) {
        return service.applyLoan(auth.getName(), loan);
    }

    // Get + Filter loans
    @GetMapping
    public List<Loan> getLoans(
            Authentication auth,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate) {

        return service.filterLoans(
                auth.getName(),
                type,
                category,
                startDate,
                endDate
        );
    }
}