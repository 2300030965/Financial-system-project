package com.klef.fsad.service.viewer;

import com.klef.fsad.entity.Transaction;
import java.util.List;

public interface ViewerTransactionService {
    List<Transaction> getAllTransactions();
}