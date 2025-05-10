package com.example.levan.test.dto;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record AuthorDTO(
        String name,
        LocalDate doB,
        String bio
) {
}
