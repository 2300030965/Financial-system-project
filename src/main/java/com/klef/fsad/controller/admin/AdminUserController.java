package com.klef.fsad.controller.admin;

import com.klef.fsad.entity.User;
import com.klef.fsad.service.admin.AdminUserService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/users")
public class AdminUserController {

    private final AdminUserService adminUserService;

    // 🔥 Constructor (no Lombok)
    public AdminUserController(AdminUserService adminUserService) {
        this.adminUserService = adminUserService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return adminUserService.getAllUsers();
    }

    @PatchMapping("/{id}/status")
    public User updateStatus(@PathVariable Long id, @RequestParam String status) {
        return adminUserService.updateStatus(id, status);
    }
}