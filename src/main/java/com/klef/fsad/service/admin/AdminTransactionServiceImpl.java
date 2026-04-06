package com.klef.fsad.service.admin;

import com.klef.fsad.entity.Transaction;
import com.klef.fsad.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminTransactionServiceImpl implements AdminTransactionService {

    @Autowired
    private TransactionRepository repo;

    @Override
    public List<Transaction> getAllTransactions() {
        return repo.findAll();
    }

    @Override
    public Transaction updateTransaction(Long id, Transaction t) {
        Transaction tr = repo.findById(id).orElseThrow();

        tr.setAmount(t.getAmount());
        tr.setType(t.getType());
        tr.setStatus(t.getStatus());

        return repo.save(tr);
    }
}