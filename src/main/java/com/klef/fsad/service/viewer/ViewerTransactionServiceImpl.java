package com.klef.fsad.service.viewer;

import com.klef.fsad.entity.Transaction;
import com.klef.fsad.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewerTransactionServiceImpl implements ViewerTransactionService {

    private final TransactionRepository repository;

    public ViewerTransactionServiceImpl(TransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }
}