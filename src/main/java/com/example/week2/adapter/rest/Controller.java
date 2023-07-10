package com.example.week2.adapter.rest;

import com.example.week2.application.CustomerServiceInterface;
import com.example.week2.domain.Customer;
import org.springframework.web.bind.annotation.*;


@RestController
public class Controller {
    private final CustomerServiceInterface customerService;

    Controller(CustomerServiceInterface customerService){
        this.customerService = customerService;
    }

    @PostMapping
    public Customer create(@RequestBody Customer customer){
        return customerService.create(customer);
    }

    @PutMapping
    public Customer update(@RequestBody Customer customer) {
        return customerService.update(customer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        customerService.delete(id);
    }

    @GetMapping("/{id}")
    public Customer get(@PathVariable("id") int id) {
        return customerService.get(id);
    }
 
}
