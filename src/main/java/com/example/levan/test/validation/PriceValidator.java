package com.example.levan.test.validation;

import com.example.levan.test.anotation.ValidPrice;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PriceValidator implements ConstraintValidator<ValidPrice, Double> {

    @Override
    public boolean isValid(Double price, ConstraintValidatorContext constraintValidatorContext) {
        return price > 0;
    }
}
