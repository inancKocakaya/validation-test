package com.kocakaya.validation.sample.repository;

import com.kocakaya.validation.sample.Customer;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public Optional<Customer> findById(long id) {
        return Optional.of(new Customer(1,"first name", LocalDate.of(1990, 1, 1)));
    }
}
