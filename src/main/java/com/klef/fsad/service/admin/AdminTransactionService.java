package com.klef.fsad.service.admin;

import com.klef.fsad.entity.Transaction;
import java.util.List;

public interface AdminTransactionService {
    List<Transaction> getAllTransactions();
    Transaction updateTransaction(Long id, Transaction t);
}