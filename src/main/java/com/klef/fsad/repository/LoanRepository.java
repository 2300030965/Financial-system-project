package com.klef.fsad.repository;

import com.klef.fsad.entity.Loan;
import com.klef.fsad.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    List<Loan> findByUser(User user);

    List<Loan> findByUserEmail(String email);

    List<Loan> findByUserEmailAndType(String email, String type);

    List<Loan> findByUserEmailAndCategory(String email, String category);

    List<Loan> findByUserEmailAndStartDateBetween(String email, LocalDate start, LocalDate end);
}