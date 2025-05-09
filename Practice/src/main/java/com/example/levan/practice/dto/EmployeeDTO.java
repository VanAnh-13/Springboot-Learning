package com.example.levan.practice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
public record EmployeeDTO(
        Long userId,
        Long departmentId,
        Long positionId,
        String fullName,
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate dateOfBirth,
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate hiredDate,
        BigDecimal salary
) {
}
