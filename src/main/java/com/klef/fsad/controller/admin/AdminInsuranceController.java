package com.klef.fsad.controller.admin;

import com.klef.fsad.entity.Insurance;
import com.klef.fsad.service.admin.AdminInsuranceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/insurance")
public class AdminInsuranceController {

    private final AdminInsuranceService service;

    public AdminInsuranceController(AdminInsuranceService service) {
        this.service = service;
    }

    // ✅ View all
    @GetMapping
    public List<Insurance> getAll() {
        return service.getAll();
    }

    // ✅ Approve
    @PutMapping("/{id}/approve")
    public Insurance approve(@PathVariable Long id) {
        return service.approve(id);
    }

    // ✅ Reject
    @PutMapping("/{id}/reject")
    public Insurance reject(@PathVariable Long id) {
        return service.reject(id);
    }

    // ✅ Delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}