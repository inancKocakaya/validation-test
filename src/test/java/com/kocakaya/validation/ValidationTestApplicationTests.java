package com.kocakaya.validation;

import com.kocakaya.validation.exception.ValidationException;
import com.kocakaya.validation.sample.Customer;
import com.kocakaya.validation.sample.CustomerValidator;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidationTestApplicationTests {

	@Test
	void test() {
		var validationException = assertThrows(ValidationException.class, () -> new CustomerValidator()
				.valider(new Customer(null, LocalDate.of(2026, 1, 1))));

		assertEquals(2, validationException.getMessages().size());
		assertTrue(List.of("The first name should not be null",
				"The birth date should be in the past").containsAll(validationException.getMessages()));
	}
}
