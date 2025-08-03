package com.michaelackerman.team_collaboration_api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michaelackerman.team_collaboration_api.entity.User;
import com.michaelackerman.team_collaboration_api.service.AuthenticationService;
import com.michaelackerman.team_collaboration_api.dto.RegistrationDTO;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody RegistrationDTO registerRequest) {
        User user = new User(registerRequest.getUsername(), registerRequest.getPassword(), registerRequest.getEmail(), registerRequest.getFirstName(), registerRequest.getLastName());
        return authenticationService.registerUser(user);
    }
}
