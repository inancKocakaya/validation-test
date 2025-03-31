package com.kocakaya.validation.tooling;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RulesValidator {

    private final Validator validator;

    public void validate(Object object) {
        var constraintViolations = validator.validate(object);

        if (!constraintViolations.isEmpty()) {
            throw new ValidationException(constraintViolations.stream().map(ConstraintViolation::getMessage).toList());
        }


    }
}
