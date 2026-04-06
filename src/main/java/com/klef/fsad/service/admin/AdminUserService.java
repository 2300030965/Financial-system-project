package com.klef.fsad.service.admin;

import com.klef.fsad.entity.User;
import java.util.List;

public interface AdminUserService {

    List<User> getAllUsers();

    User updateStatus(Long id, String status);
}