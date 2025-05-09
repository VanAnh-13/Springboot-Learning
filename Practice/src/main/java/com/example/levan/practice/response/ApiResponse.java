package com.example.levan.practice.response;

import lombok.Builder;

@Builder
public record ApiResponse<T>(
        int status,
        String message,
        T data
) {
}
