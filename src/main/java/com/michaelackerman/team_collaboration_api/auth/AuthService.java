package com.michaelackerman.team_collaboration_api.auth;

import com.michaelackerman.team_collaboration_api.auth.dto.RegisterRequestDTO;
import com.michaelackerman.team_collaboration_api.auth.dto.LoginRequestDTO;
import com.michaelackerman.team_collaboration_api.exception.UserAlreadyExistsException;
import com.michaelackerman.team_collaboration_api.user.User;
import com.michaelackerman.team_collaboration_api.user.UserMapper;
import com.michaelackerman.team_collaboration_api.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public User registerUser(RegisterRequestDTO registerRequestDTO) {
        User newUser = userMapper.fromRegisterRequestDTO(registerRequestDTO);
        validateUserUniqueness(newUser);

        newUser.setPassword(hashPassword(registerRequestDTO.getPassword()));
        return userService.createUser(newUser);
    }



    private void validateUserUniqueness(User user) {
        if (userService.findUserByEmail(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("User with email " + user.getEmail() + " already exists.");
        }

        if (userService.findUserByUsername(user.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException("User with username " + user.getUsername() + " already exists.");
        }
    }

    private String hashPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
