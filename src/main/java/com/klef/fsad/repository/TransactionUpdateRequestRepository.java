package com.klef.fsad.repository;

import com.klef.fsad.entity.TransactionUpdateRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionUpdateRequestRepository extends JpaRepository<TransactionUpdateRequest, Long> {
}