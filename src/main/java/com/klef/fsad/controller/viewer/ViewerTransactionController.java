package com.klef.fsad.controller.viewer;

import com.klef.fsad.entity.Transaction;
import com.klef.fsad.service.viewer.ViewerTransactionService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/viewer/transactions")
public class ViewerTransactionController {

    private final ViewerTransactionService service;

    public ViewerTransactionController(ViewerTransactionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return service.getAllTransactions();
    }
}