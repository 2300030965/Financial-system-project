package com.klef.fsad.repository;

import com.klef.fsad.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvestmentRepository extends JpaRepository<Investment, Long> {

    List<Investment> findByUser(User user);
    List<Investment> findByUserEmail(String email);

    List<Investment> findByUserEmailAndType(String email, String type);

    List<Investment> findByUserEmailAndCategory(String email, String category);

    List<Investment> findByUserEmailAndDateBetween(
            String email,
            java.time.LocalDate start,
            java.time.LocalDate end
    );
}