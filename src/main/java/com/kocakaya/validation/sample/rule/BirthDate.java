package com.kocakaya.validation.sample.rule;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.LocalDate;

import static com.kocakaya.validation.sample.rule.BirthDate.BirthDateValidator;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BirthDateValidator.class)
public @interface BirthDate {

    String message() default "{customer.birth.date.not.valid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class BirthDateValidator implements ConstraintValidator<BirthDate, LocalDate> {
        @Override
        public void initialize(BirthDate constraintAnnotation) {
        }

        @Override
        public boolean isValid(LocalDate value, ConstraintValidatorContext constraintValidatorContext) {
            return value.isBefore(LocalDate.now());
        }
    }

}
