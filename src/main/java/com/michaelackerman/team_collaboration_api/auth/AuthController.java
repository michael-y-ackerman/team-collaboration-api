package com.michaelackerman.team_collaboration_api.auth;

import com.michaelackerman.team_collaboration_api.auth.dto.UserRegistrationDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michaelackerman.team_collaboration_api.user.User;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public User registerUser(@Valid @RequestBody UserRegistrationDTO newUser) {
        return authService.registerUser(newUser);
    }
}
