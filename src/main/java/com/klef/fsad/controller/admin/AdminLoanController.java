package com.klef.fsad.controller.admin;

import com.klef.fsad.entity.Loan;
import com.klef.fsad.service.admin.AdminLoanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/loans")
public class AdminLoanController {

    private final AdminLoanService service;

    public AdminLoanController(AdminLoanService service) {
        this.service = service;
    }

    // ✅ Get all loans
    @GetMapping
    public List<Loan> getAllLoans() {
        return service.getAllLoans();
    }

    // ✅ Approve loan
    @PutMapping("/{id}/approve")
    public Loan approveLoan(@PathVariable Long id) {
        return service.approveLoan(id);
    }

    // ✅ Reject loan
    @PutMapping("/{id}/reject")
    public Loan rejectLoan(@PathVariable Long id) {
        return service.rejectLoan(id);
    }
}