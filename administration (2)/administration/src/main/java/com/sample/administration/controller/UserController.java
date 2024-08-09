package com.sample.administration.controller;

import com.sample.administration.dto.LoginRequestDTO;
import com.sample.administration.dto.RegistrationRequest;
import com.sample.administration.entity.User;
import com.sample.administration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService1) {
        this.userService = userService1;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDTO requestLogin) {
        boolean isAuthenticated = userService.authenticate(requestLogin.getUsername(), requestLogin.getPassword());

        if (isAuthenticated) {
            // Here you can call other APIs or services as needed
            return "Login successful!";
        } else {
            return "Invalid username or password";
        }
    }

    @PostMapping("/register")
    public User register(@RequestBody RegistrationRequest request) {
        return userService.registerUser(request.getUsername(), request.getPassword());
    }
}