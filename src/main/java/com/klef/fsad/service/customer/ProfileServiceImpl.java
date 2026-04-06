package com.klef.fsad.service.customer;

import com.klef.fsad.entity.User;
import com.klef.fsad.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final UserRepository userRepository;

    // 🔥 Constructor (instead of Lombok)
    public ProfileServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getProfile(String email) {

        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}