package com.michaelackerman.team_collaboration_api.auth;

import com.michaelackerman.team_collaboration_api.auth.dto.RegisterRequestDTO;
import com.michaelackerman.team_collaboration_api.auth.dto.LoginRequestDTO;
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
    public User registerUser(@Valid @RequestBody RegisterRequestDTO registerRequestDTO) {
        return authService.registerUser(registerRequestDTO);
    }

    @PostMapping("/login")
    public User loginUser(@Valid @RequestBody LoginRequestDTO loginRequestDTO) {
        return authService.loginUser(loginRequestDTO);
    }
}
