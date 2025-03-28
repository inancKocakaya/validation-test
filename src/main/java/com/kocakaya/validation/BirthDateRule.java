package com.kocakaya.validation;

import java.time.LocalDate;

public class BirthDateRule extends ValidationRule<LocalDate, Customer> {

    @Override
    public boolean isValid(LocalDate value) {
        return value.isBefore(LocalDate.now());
    }
}
