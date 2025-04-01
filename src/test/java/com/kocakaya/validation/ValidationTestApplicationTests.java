package com.kocakaya.validation;

import com.kocakaya.validation.sample.Address;
import com.kocakaya.validation.sample.Customer;
import com.kocakaya.validation.tooling.RulesValidator;
import com.kocakaya.validation.tooling.ValidationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ValidationTestApplicationTests {

    @Autowired
    private RulesValidator rulesValidator;

    @Test
    void shouldThrowsValidationExceptionWhenCustomerIsInvalid() {
        var validationException = assertThrows(ValidationException.class, () -> rulesValidator.validate(new Customer(1, null, LocalDate.of(2026, 1, 1))));

        assertEquals(3, validationException.getMessages().size());
        assertTrue(List.of("The customer first name should not be null",
                        "The customer id is not unique",
                        "The customer birth date must be in the past")
                .containsAll(validationException.getMessages()));
    }

    @Test
    void shouldThrowsValidationExceptionWhenStreetNumberIsInvalid() {
        var validationException = assertThrows(ValidationException.class, () -> rulesValidator.validate(new Address(0)));
        assertEquals(1, validationException.getMessages().size());
        assertTrue(List.of("The address street number must be higher than 1")
                .containsAll(validationException.getMessages()));
    }
}
