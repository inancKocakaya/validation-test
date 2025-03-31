package com.kocakaya.validation.sample;

import com.kocakaya.validation.sample.rule.BirthDate;
import com.kocakaya.validation.sample.rule.UniqueCustomerId;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Valid
public class Customer {

    @UniqueCustomerId
    private int id;

    @NotNull(message = "{customer.firstName.notNull}")
    private String firstName;

    @BirthDate
    private LocalDate birthDate;
}
