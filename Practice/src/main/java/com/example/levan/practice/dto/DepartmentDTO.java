package com.example.levan.practice.dto;

import lombok.Builder;

@Builder
public record DepartmentDTO(
        String name,
        String description
) {
}
