package com.example.levan.practice.entity;

import com.example.levan.practice.annotation.ValidEmail;
import com.example.levan.practice.annotation.ValidPassword;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "username", unique = true, nullable = false, length = 50)
    @NotNull
    private String username;

    @Column(name = "password")
    @ValidPassword
    private String password;

    @Column(name = "email", unique = true, length = 100)
    @ValidEmail
    private String email;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @PrePersist
    private void default_createAt() {
        this.createAt = LocalDateTime.now();
    }
}
