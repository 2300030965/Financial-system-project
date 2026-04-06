package com.klef.fsad.service.admin;

import com.klef.fsad.entity.Investment;
import com.klef.fsad.repository.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminInvestmentServiceImpl implements AdminInvestmentService {

    @Autowired
    private InvestmentRepository repo;

    @Override
    public List<Investment> getAllInvestments() {
        return repo.findAll();
    }
}