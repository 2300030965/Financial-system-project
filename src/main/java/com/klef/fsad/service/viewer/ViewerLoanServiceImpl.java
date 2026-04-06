package com.klef.fsad.service.viewer;

import com.klef.fsad.entity.Loan;
import com.klef.fsad.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewerLoanServiceImpl implements ViewerLoanService {

    private final LoanRepository repository;

    public ViewerLoanServiceImpl(LoanRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Loan> getAllLoans() {
        return repository.findAll();
    }
}