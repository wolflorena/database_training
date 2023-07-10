package com.example.week2.application;

import com.example.week2.domain.Address;
import com.example.week2.domain.Customer;

public interface CustomerServiceInterface {
    abstract Customer create(Customer customer);
    abstract Customer update(Customer customer);
    abstract void delete(int id);
    abstract Customer get(int id);
}
