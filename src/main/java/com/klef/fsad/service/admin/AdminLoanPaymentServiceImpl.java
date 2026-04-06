package com.klef.fsad.service.admin;

import com.klef.fsad.entity.LoanPayment;
import com.klef.fsad.repository.LoanPaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminLoanPaymentServiceImpl implements AdminLoanPaymentService {

    private final LoanPaymentRepository repository;

    public AdminLoanPaymentServiceImpl(LoanPaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<LoanPayment> getAllPayments() {
        return repository.findAll();
    }
}