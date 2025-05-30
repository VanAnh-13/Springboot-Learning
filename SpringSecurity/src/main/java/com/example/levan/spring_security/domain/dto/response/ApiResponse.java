package com.example.levan.spring_security.domain.dto.response;

import lombok.Builder;

@Builder
public record ApiResponse<T>(
        Integer code,
        String message,
        T data
) {
}
