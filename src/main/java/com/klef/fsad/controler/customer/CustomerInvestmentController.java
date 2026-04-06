package com.klef.fsad.controler.customer;

import com.klef.fsad.entity.Investment;
import com.klef.fsad.service.customer.CustomerInvestmentService;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer/investments")
public class CustomerInvestmentController {

    private final CustomerInvestmentService service;

    // 🔥 Constructor (instead of Lombok)
    public CustomerInvestmentController(CustomerInvestmentService service) {
        this.service = service;
    }

    @PostMapping
    public Investment invest(Authentication auth, @RequestBody Investment inv) {
        return service.invest(auth.getName(), inv);
    }

    @GetMapping
    public List<Investment> get(Authentication auth) {
        return service.getMy(auth.getName());
    }
    
    @GetMapping
    public List<Investment> getInvestments(
            Authentication auth,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate) {

        return service.filterInvestments(
                auth.getName(),
                type,
                category,
                startDate,
                endDate
        );
    }
}