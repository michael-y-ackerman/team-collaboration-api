package com.michaelackerman.team_collaboration_api.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import com.michaelackerman.team_collaboration_api.entity.User;
import com.michaelackerman.team_collaboration_api.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String username, String hashedPassword, String email, String firstName, String lastName) {
        User user = new User(username, hashedPassword, firstName, lastName, email);
        return userRepository.save(user);
    }

    public User updateLastAccessed(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        user.setLastAccessedDateTime(LocalDateTime.now());
        return userRepository.save(user);
    }
}
