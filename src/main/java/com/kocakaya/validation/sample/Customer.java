package com.kocakaya.validation;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class Customer {

    @NotNull(message = "{customer.firstName.notNull}")
    private String firstName;

    @CheckWith(value = BirthDateRule.class, message = "{customer.birthDate.invalid}")
    private LocalDate birthDate;
}
