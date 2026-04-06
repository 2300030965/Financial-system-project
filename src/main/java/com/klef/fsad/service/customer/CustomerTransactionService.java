package com.klef.fsad.service.customer;

import com.klef.fsad.entity.Transaction;
import java.util.List;

public interface CustomerTransactionService {

    Transaction create(String email, Transaction t);

    List<Transaction> getMy(String email);
    
    List<Transaction> filterTransactions(
    	    String email,
    	    String type,
    	    String category,
    	    String startDate,
    	    String endDate
    	);
}