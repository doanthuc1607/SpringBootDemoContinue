package com.sample.administration.service.impl;

import com.sample.administration.entity.User;
import com.sample.administration.repository.UserRepository;
import com.sample.administration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder bcriptPassEncoder;

    public boolean authenticate(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsername(username);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return bcriptPassEncoder.matches(password, user.getPassword());
        }
        return false;
    }

    @Override
    public User registerUser(String username, String rawPassword) {
        // Hash the password
        String encodedPassword = bcriptPassEncoder.encode(rawPassword);

        // Create a new user
        User user = new User();
        user.setUsername(username);
        user.setPassword(encodedPassword);

        // Save the user to the database
       return userRepository.save(user);
    }
}

