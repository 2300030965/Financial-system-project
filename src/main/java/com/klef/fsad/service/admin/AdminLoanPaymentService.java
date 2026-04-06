package com.klef.fsad.service.admin;

import com.klef.fsad.entity.LoanPayment;
import java.util.List;

public interface AdminLoanPaymentService {
    List<LoanPayment> getAllPayments();
}