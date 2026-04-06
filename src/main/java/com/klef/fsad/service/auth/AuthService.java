package com.klef.fsad.service.auth;

import com.klef.fsad.dto.AuthResponse;
import com.klef.fsad.dto.LoginRequest;
import com.klef.fsad.dto.RegisterRequest;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}