package com.example.levan.spring_security.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UserCreateDTO(
        @NotNull
        String username,

        @NotNull
        @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{8,}$")
        String password,

        @NotBlank
        String firstName,

        @NotBlank
        String lastName
) {
}
