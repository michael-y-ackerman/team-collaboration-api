package com.michaelackerman.team_collaboration_api.service;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.michaelackerman.team_collaboration_api.entity.User;

@Service
public class AuthenticationService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationService(UserService userService) {
        this.userService = userService;
        this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
    public User registerUser(User user) {
        // Hash the password before saving
        String hashedPassword = hashPassword(user.getPassword());
        return userService.createUser(user.getUsername(), hashedPassword, user.getEmail(), user.getFirstName(), user.getLastName());
    }

    private String hashPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
