package com.example.week2.application;


import com.example.week2.domain.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements CustomerServiceInterface{
    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;

    private final ModelMapper modelMapper;


    public CustomerService(CustomerRepository customerRepository, AddressRepository addressRepository, ModelMapper modelMapper){
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
        this.modelMapper = modelMapper;
    }

    public CustomerDTO create(Customer customer){
        if(!customerRepository.existsById(customer.getCustomerId())) {
            addressRepository.save(customer.getAddress());
            return modelMapper.map(customerRepository.save(customer), CustomerDTO.class);
        }
        return null;
    }

    public CustomerDTO update(Customer customer){
        if(customerRepository.existsById(customer.getCustomerId())) {
               //addressRepository.save(customer.getAddress());
            return modelMapper.map(customerRepository.save(customer), CustomerDTO.class);
        }
        return null;
    }

    public void delete(int id){
        customerRepository.deleteById(id);
    }

    public CustomerDTO get(int id){
        return modelMapper.map(customerRepository.findById(id).get(), CustomerDTO.class);
    }



}
