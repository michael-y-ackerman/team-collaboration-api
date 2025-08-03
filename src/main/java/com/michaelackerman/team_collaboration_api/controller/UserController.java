package com.michaelackerman.team_collaboration_api.controller;

import org.springframework.web.bind.annotation.RestController;
import com.michaelackerman.team_collaboration_api.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
}
