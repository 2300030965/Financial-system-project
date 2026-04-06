package com.klef.fsad.repository;

import com.klef.fsad.entity.*;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByUser(User user);
    List<Transaction> findByUserEmail(String email);

    List<Transaction> findByUserEmailAndType(String email, String type);

    List<Transaction> findByUserEmailAndCategory(String email, String category);

    List<Transaction> findByUserEmailAndDateBetween(
            String email,
            LocalDate start,
            LocalDate end
    );
}