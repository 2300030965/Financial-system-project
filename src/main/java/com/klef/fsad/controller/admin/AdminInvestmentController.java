package com.klef.fsad.controller.admin;

import com.klef.fsad.entity.Investment;
import com.klef.fsad.service.admin.AdminInvestmentService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/investments")
public class AdminInvestmentController {

    private final AdminInvestmentService service;

    // 🔥 Constructor (instead of Lombok)
    public AdminInvestmentController(AdminInvestmentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Investment> getAll() {
        return service.getAllInvestments();
    }
}