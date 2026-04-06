package com.klef.fsad.security;

import org.springframework.stereotype.Service;

@Service
public class JwtService {

    public String generateToken(String email, String role) {
        return email + "-" + role + "-token";
    }

    // 🔥 Extract email
    public String extractEmail(String token) {
        return token.split("-")[0];
    }

    // 🔥 Extract role
    public String extractRole(String token) {
        return token.split("-")[1];
    }
}