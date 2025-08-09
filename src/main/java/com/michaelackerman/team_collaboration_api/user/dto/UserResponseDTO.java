package com.michaelackerman.team_collaboration_api.user.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponseDTO {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime createdDateTime;
    private LocalDateTime lastAccessedDateTime;
}
