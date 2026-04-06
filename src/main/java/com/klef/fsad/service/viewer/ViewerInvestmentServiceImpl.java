package com.klef.fsad.service.viewer;

import com.klef.fsad.entity.Investment;
import com.klef.fsad.repository.InvestmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewerInvestmentServiceImpl implements ViewerInvestmentService {

    private final InvestmentRepository repository;

    public ViewerInvestmentServiceImpl(InvestmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Investment> getAllInvestments() {
        return repository.findAll();
    }
}