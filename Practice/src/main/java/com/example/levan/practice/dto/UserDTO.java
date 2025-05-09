package com.example.levan.practice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record UserDTO(
        String username,
        String password,
        String email,
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDateTime create_at
) {
}
