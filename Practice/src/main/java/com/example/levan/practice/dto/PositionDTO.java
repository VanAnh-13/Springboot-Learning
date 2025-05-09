package com.example.levan.practice.dto;


import lombok.Builder;


@Builder
public record PositionDTO(
        String title,
        String description
) {
}
