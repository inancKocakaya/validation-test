package com.kocakaya.validation.sample.repository;

import com.kocakaya.validation.sample.Customer;

import java.util.Optional;

public interface CustomerRepository {

    Optional<Customer> findById(long id);
}
