package com.klef.fsad.controler.customer;

import com.klef.fsad.entity.Insurance;
import com.klef.fsad.service.customer.CustomerInsuranceService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer/insurance")
public class CustomerInsuranceController {

    private final CustomerInsuranceService service;

    public CustomerInsuranceController(CustomerInsuranceService service) {
        this.service = service;
    }

    // ✅ Take insurance
    @PostMapping
    public Insurance create(Authentication auth, @RequestBody Insurance ins) {
        return service.create(auth.getName(), ins);
    }

    // ✅ View own insurance
    @GetMapping
    public List<Insurance> get(Authentication auth) {
        return service.getMy(auth.getName());
    }

    // ✅ Update
    @PutMapping("/{id}")
    public Insurance update(@PathVariable Long id, @RequestBody Insurance ins) {
        return service.update(id, ins);
    }

    // ✅ Delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}