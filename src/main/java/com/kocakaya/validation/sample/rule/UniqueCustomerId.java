package com.kocakaya.validation.sample.rule;

import com.kocakaya.validation.sample.repository.CustomerRepository;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import lombok.RequiredArgsConstructor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.kocakaya.validation.sample.rule.UniqueCustomerId.UniqueCustomerIdValidator;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueCustomerIdValidator.class)
public @interface UniqueCustomerId {

    String message() default "{customer.id.not.unique}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @RequiredArgsConstructor
    class UniqueCustomerIdValidator implements ConstraintValidator<UniqueCustomerId, Integer> {

        private final CustomerRepository customerRepository;

        @Override
        public void initialize(UniqueCustomerId constraintAnnotation) {
        }

        @Override
        public boolean isValid(Integer id, ConstraintValidatorContext constraintValidatorContext) {
            return customerRepository.findById(id).isEmpty();
        }
    }
}
