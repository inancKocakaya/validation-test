package com.kocakaya.validation.tooling;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckWith.CheckWithValidator.class)
@Documented
@Repeatable(CheckWith.List.class)
public @interface CheckWith {
    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @SuppressWarnings("rawtypes")
    Class<? extends ValidationRule> value();

    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.FIELD})
    @interface List {
        CheckWith[] value();
    }

    class CheckWithValidator implements ConstraintValidator<CheckWith, Object> {

        private ValidationRule<?, ?> validationRule;

        @Override
        public void initialize(CheckWith constraintAnnotation) {
            try {
                validationRule = constraintAnnotation.value().getConstructor().newInstance();
            } catch (ReflectiveOperationException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override
        public boolean isValid(Object value, ConstraintValidatorContext context) {
            validationRule.setHibernateContext(context.unwrap(HibernateConstraintValidatorContext.class));
            return validationRule.internalValidation(value);
        }
    }
}
