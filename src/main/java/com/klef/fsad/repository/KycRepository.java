package com.klef.fsad.repository;

import com.klef.fsad.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KycRepository extends JpaRepository<Kyc, Long> {

    Optional<Kyc> findByUser(User user);
}