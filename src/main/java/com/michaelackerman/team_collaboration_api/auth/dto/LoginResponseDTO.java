package com.michaelackerman.team_collaboration_api.auth.dto;

import com.michaelackerman.team_collaboration_api.user.dto.UserResponseDTO;

public class LoginResponseDTO {
    private JWTResponseDTO jwt;
    private UserResponseDTO user;
}
