package com.michaelackerman.team_collaboration_api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michaelackerman.team_collaboration_api.entity.User;
import com.michaelackerman.team_collaboration_api.service.AuthenticationService;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User newUser) {

        return authenticationService.registerUser(newUser);
    }
}
