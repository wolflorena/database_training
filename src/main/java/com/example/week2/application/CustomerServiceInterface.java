package com.example.week2.application;

import com.example.week2.domain.Address;
import com.example.week2.domain.Customer;
import com.example.week2.domain.CustomerDTO;
import com.example.week2.domain.Product;

public interface CustomerServiceInterface {
    abstract CustomerDTO create(Customer customer);
    abstract CustomerDTO update(Customer customer);
    abstract void delete(int id);
    abstract CustomerDTO get(int id);

}
