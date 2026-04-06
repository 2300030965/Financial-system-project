package com.klef.fsad.repository;

import com.klef.fsad.entity.InvestmentPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvestmentPlanRepository extends JpaRepository<InvestmentPlan, Long> {

    List<InvestmentPlan> findByActiveTrue();
}