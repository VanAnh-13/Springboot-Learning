package com.example.levan.spring_security.domain.dto.response;

public record UserDTO(
        String id,
        String username,
        String firstName,
        String lastName
) {
}
