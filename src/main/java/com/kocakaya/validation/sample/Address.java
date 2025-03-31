package com.kocakaya.validation.sample;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Valid
public class Address {

    @Min(value = 1, message = "{address.street.number.incorrect}")
    private int streetNumber;
}
