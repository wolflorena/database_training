package com.example.week2.adapter.rest;

import com.example.week2.application.CustomerServiceInterface;
import com.example.week2.application.ProductServiceInterface;
import com.example.week2.domain.Customer;
import com.example.week2.domain.CustomerDTO;
import com.example.week2.domain.Product;
import com.example.week2.domain.ProductDTO;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/customer")
public class Controller {
    private final CustomerServiceInterface customerService;
    private final ProductServiceInterface productService;

    private final ModelMapper modelMapper;

    Controller(CustomerServiceInterface customerService, ProductServiceInterface productService, ModelMapper modelMapper){
        this.customerService = customerService;
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public CustomerDTO create(@RequestBody Customer customer){
        return modelMapper.map(customerService.create(customer), CustomerDTO.class);
    }

    @PutMapping
    public CustomerDTO update(@RequestBody Customer customer) {
        return modelMapper.map(customerService.update(customer), CustomerDTO.class);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        customerService.delete(id);
    }

    @GetMapping("/{id}")
    public CustomerDTO get(@PathVariable("id") int id) {
        return modelMapper.map(customerService.get(id), CustomerDTO.class);
    }

    @PostMapping("/{id}/product")
    public ProductDTO buyProduct(@PathVariable("id") int id, @RequestBody Product product){
        return modelMapper.map(productService.buyProduct(id,product), ProductDTO.class);
    }

}
