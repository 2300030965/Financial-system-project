package com.klef.fsad.controler.customer;

import com.klef.fsad.entity.Transaction;
import com.klef.fsad.service.customer.CustomerTransactionService;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer/transactions")
public class CustomerTransactionController {

    private final CustomerTransactionService service;

    // 🔥 Constructor (no Lombok)
    public CustomerTransactionController(CustomerTransactionService service) {
        this.service = service;
    }

    @PostMapping
    public Transaction create(Authentication auth, @RequestBody Transaction t) {
        return service.create(auth.getName(), t);
    }

    @GetMapping
    public List<Transaction> get(Authentication auth) {
        return service.getMy(auth.getName());
    }
    
    @GetMapping
    public List<Transaction> getTransactions(
            Authentication auth,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate) {

        return service.filterTransactions(
                auth.getName(),
                type,
                category,
                startDate,
                endDate
        );
    }
}