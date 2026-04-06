package com.klef.fsad.service.admin;

import com.klef.fsad.entity.User;
import com.klef.fsad.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    private final UserRepository userRepository;

    public AdminUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateStatus(Long id, String status) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setStatus(Enum.valueOf(
                com.klef.fsad.enums.UserStatus.class, status
        ));

        return userRepository.save(user);
    }
}