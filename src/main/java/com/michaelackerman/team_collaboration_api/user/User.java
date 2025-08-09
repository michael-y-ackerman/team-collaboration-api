package com.michaelackerman.team_collaboration_api.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


/**
 * Represents a user entity for the team collaboration API.
 * This class maps to the "users" table in the database and includes
 * validation annotations. The password field should be hashed before storage.
 *
 * @author Michael Ackerman
 * @version 1.0
 * <p>
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(exclude = "password")
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email"}),
        @UniqueConstraint(columnNames = {"username"})
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username is required.")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters.")
    @Column(nullable = false, length = 50)
    private String username;

    @NotBlank(message = "Password is required.")
    @Size(min = 8, max = 255, message = "Password must be between 8 and 255 characters.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // Ensures that password never serializes to JSON
    @Column(nullable = false)
    private String password;

    @NotBlank(message = "First name is required.")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters.")
    @Column(nullable = false, length = 50)
    private String firstName;

    @NotBlank(message = "Last name is required.")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters.")
    @Column(nullable = false, length = 50)
    private String lastName;

    @NotBlank(message = "Email is required.")
    @Size(max = 100, message = "Email cannot exceed 100 characters.")
    @Email(message = "Please provide a valid email address.")
    @Column(nullable = false, length = 100)
    private String email;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDateTime;

    private LocalDateTime lastAccessedDateTime;

    public User(String username, String password, String firstName, String lastName, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        // lastAccessedDateTime is left to be set by the service layer
    }
}