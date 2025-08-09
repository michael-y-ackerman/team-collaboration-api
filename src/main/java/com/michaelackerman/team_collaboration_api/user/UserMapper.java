package com.michaelackerman.team_collaboration_api.user;

import com.michaelackerman.team_collaboration_api.auth.dto.RegisterRequestDTO;
import com.michaelackerman.team_collaboration_api.user.dto.UserResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDTO toResponseDto(User user);

    User fromRegisterRequestDTO(RegisterRequestDTO registerRequestDTO);
}
