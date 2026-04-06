package com.klef.fsad.controller.admin;

import com.klef.fsad.entity.LoanPayment;
import com.klef.fsad.service.admin.AdminLoanPaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/loan-payments")
public class AdminLoanPaymentController {

    private final AdminLoanPaymentService service;

    public AdminLoanPaymentController(AdminLoanPaymentService service) {
        this.service = service;
    }

    // ✅ Get all loan payments
    @GetMapping
    public List<LoanPayment> getAllPayments() {
        return service.getAllPayments();
    }
}