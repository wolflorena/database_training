package com.example.week2.application;


import com.example.week2.domain.Address;
import com.example.week2.domain.AddressRepository;
import com.example.week2.domain.Customer;
import com.example.week2.domain.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements CustomerServiceInterface{
    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;

    public CustomerService(CustomerRepository customerRepository, AddressRepository addressRepository){
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
    }

    public Customer create(Customer customer){
        if(!customerRepository.existsById(customer.getCustomerId())) {
            addressRepository.save(customer.getAddress());
            return customerRepository.save(customer);
        }
        return null;
    }

    public Customer update(Customer customer){
        if(customerRepository.existsById(customer.getCustomerId())) {
            addressRepository.save(customer.getAddress());
            return customerRepository.save(customer);
        }
        return null;
    }

    public void delete(int id){
        customerRepository.deleteById(id);
    }

    public Customer get(int id){
        return customerRepository.findById(id).get();
    }



}
