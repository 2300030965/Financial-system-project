package com.klef.fsad.controller.admin;

import com.klef.fsad.entity.Transaction;
import com.klef.fsad.service.admin.AdminTransactionService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/transactions")
public class AdminTransactionController {

    private final AdminTransactionService service;

    // 🔥 Constructor (no Lombok)
    public AdminTransactionController(AdminTransactionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Transaction> getAll() {
        return service.getAllTransactions();
    }

    @PutMapping("/{id}")
    public Transaction update(@PathVariable Long id, @RequestBody Transaction req) {
        return service.updateTransaction(id, req);
    }
}