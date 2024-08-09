package com.sample.administration.service;

import com.sample.administration.entity.User;

public interface UserService {
    User registerUser(String username, String rawPassword);

    boolean authenticate(String username, String rawPassword);
}
