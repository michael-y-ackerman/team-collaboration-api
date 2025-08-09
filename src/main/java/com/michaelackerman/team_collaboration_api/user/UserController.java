package com.michaelackerman.team_collaboration_api.user;

import com.michaelackerman.team_collaboration_api.user.dto.UserResponseDTO;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/{userId}")
    public UserResponseDTO getUserById(@Positive @PathVariable Long userId) {
        User user = userService.findUserById(userId);
        return userMapper.toResponseDto(user);
    }
}
