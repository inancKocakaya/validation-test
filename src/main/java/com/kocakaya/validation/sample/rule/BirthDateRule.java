package com.kocakaya.validation.sample.rule;

import com.kocakaya.validation.tooling.ValidationRule;
import com.kocakaya.validation.sample.Customer;

import java.time.LocalDate;

public class BirthDateRule extends ValidationRule<LocalDate, Customer> {

    @Override
    public boolean isValid(LocalDate value) {
        return value.isBefore(LocalDate.now());
    }
}
