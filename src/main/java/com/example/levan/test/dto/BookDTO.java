package com.example.levan.test.dto;

import lombok.Builder;

@Builder
public record BookDTO(
        String name,
        String description,
        Double price,
        Long author_id,
        Long category_id
) {
}
