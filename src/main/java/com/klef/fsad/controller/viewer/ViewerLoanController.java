package com.klef.fsad.controller.viewer;

import com.klef.fsad.entity.Loan;
import com.klef.fsad.service.viewer.ViewerLoanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/viewer/loans")
public class ViewerLoanController {

    private final ViewerLoanService service;

    public ViewerLoanController(ViewerLoanService service) {
        this.service = service;
    }

    @GetMapping
    public List<Loan> getAllLoans() {
        return service.getAllLoans();
    }
}