package com.kocakaya.validation.sample;

import com.kocakaya.validation.sample.rule.BirthDateRule;
import com.kocakaya.validation.tooling.CheckWith;
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
