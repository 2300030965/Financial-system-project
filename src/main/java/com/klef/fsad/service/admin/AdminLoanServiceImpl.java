package com.klef.fsad.service.admin;

import com.klef.fsad.entity.Loan;
import com.klef.fsad.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminLoanServiceImpl implements AdminLoanService {

    @Autowired
    private LoanRepository repo;

    @Override
    public List<Loan> getAllLoans() {
        return repo.findAll();
    }

    @Override
    public Loan approveLoan(Long id) {
        Loan loan = repo.findById(id).orElseThrow();
        loan.setStatus("APPROVED");
        return repo.save(loan);
    }

    @Override
    public Loan rejectLoan(Long id) {
        Loan loan = repo.findById(id).orElseThrow();
        loan.setStatus("REJECTED");
        return repo.save(loan);
    }
}