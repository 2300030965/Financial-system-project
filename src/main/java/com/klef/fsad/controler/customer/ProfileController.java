package com.klef.fsad.controler.customer;

import com.klef.fsad.entity.User;
import com.klef.fsad.service.customer.ProfileService;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer/profile")
public class ProfileController {

    private final ProfileService service;

    // 🔥 Constructor (no Lombok)
    public ProfileController(ProfileService service) {
        this.service = service;
    }

    @GetMapping
    public User get(Authentication auth) {
        return service.getProfile(auth.getName());
    }
}