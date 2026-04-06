package com.klef.fsad.service.customer;

import com.klef.fsad.entity.User;

public interface ProfileService {

    User getProfile(String email);
}