package com.klef.fsad.service.customer;

import com.klef.fsad.entity.Transaction;
import com.klef.fsad.entity.User;
import com.klef.fsad.repository.TransactionRepository;
import com.klef.fsad.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTransactionServiceImpl implements CustomerTransactionService {

    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;

    // 🔥 Constructor (no Lombok)
    public CustomerTransactionServiceImpl(UserRepository userRepository,
                                          TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction create(String email, Transaction t) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        t.setUser(user);
        t.setStatus("PENDING"); // simple string

        return transactionRepository.save(t);
    }

    @Override
    public List<Transaction> getMy(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return transactionRepository.findByUser(user);
        
    }
    
    @Override
    public List<Transaction> filterTransactions(
            String email,
            String type,
            String category,
            String startDate,
            String endDate) {

        if (type != null) {
            return transactionRepository.findByUserEmailAndType(email, type);
        }

        if (category != null) {
            return transactionRepository.findByUserEmailAndCategory(email, category);
        }

        if (startDate != null && endDate != null) {
            return transactionRepository.findByUserEmailAndDateBetween(
                    email,
                    java.time.LocalDate.parse(startDate),
                    java.time.LocalDate.parse(endDate)
            );
        }

        return transactionRepository.findByUserEmail(email);
    }
}