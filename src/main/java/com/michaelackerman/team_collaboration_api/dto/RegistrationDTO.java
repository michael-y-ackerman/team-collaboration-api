package com.michaelackerman.team_collaboration_api.dto;

import lombok.Data;

@Data
public class RegistrationDTO {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;

    public RegistrationDTO() {}
}