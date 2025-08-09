package com.michaelackerman.team_collaboration_api.user;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(User newUser) { return userRepository.save(newUser); }

    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public Optional<User> findUserByEmail(@NotBlank(message = "Email is required.") @Size(max = 100, message = "Email cannot exceed 100 characters.") @Email(message = "Please provide a valid email address.") String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> findUserByUsername(@NotBlank(message = "Username is required.") @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters.") String username) {
        return userRepository.findByUsername(username);
    }
}
