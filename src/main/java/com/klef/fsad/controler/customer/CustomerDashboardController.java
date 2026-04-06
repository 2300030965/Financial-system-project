package com.klef.fsad.controler.customer;

import com.klef.fsad.service.customer.CustomerDashboardService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer/dashboard")
public class CustomerDashboardController {

    private final CustomerDashboardService service;

    // 🔥 ADD THIS (IMPORTANT)
    public CustomerDashboardController(CustomerDashboardService service) {
        this.service = service;
    }

    @GetMapping
    public Object get(Authentication auth) {
        return service.getDashboard(auth.getName());
    }
    
}