package com.example.levan.practice.validation;

import com.example.levan.practice.annotation.ValidEmail;
import jakarta.validation.ConstraintValidator;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {
    @Override
    public boolean isValid(String value, jakarta.validation.ConstraintValidatorContext context) {
        return value != null && value.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
    }
}