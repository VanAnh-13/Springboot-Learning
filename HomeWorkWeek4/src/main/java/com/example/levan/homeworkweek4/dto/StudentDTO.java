package com.example.levan.homeworkweek4.dto;

import com.example.levan.homeworkweek4.models.Class;
import com.example.levan.homeworkweek4.models.Gender;
import lombok.Builder;

import java.util.Date;

@Builder
public record StudentDTO(Long id, String fullName, Date dateOfBirth, Gender gender, String email, String phoneNumber,
                         Class classId) {
}