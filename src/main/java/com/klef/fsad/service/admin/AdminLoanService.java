package com.klef.fsad.service.admin;

import com.klef.fsad.entity.Loan;
import java.util.List;

public interface AdminLoanService {

    List<Loan> getAllLoans();

    Loan approveLoan(Long id);

    Loan rejectLoan(Long id);
}