package com.example.week2.application;

import com.example.week2.domain.CustomerRepository;
import com.example.week2.domain.Product;
import com.example.week2.domain.ProductDTO;
import com.example.week2.domain.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService implements ProductServiceInterface{
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public ProductService(ProductRepository productRepository, CustomerRepository customerRepository, ModelMapper modelMapper){
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    public ProductDTO buyProduct(int id, Product product){
        customerRepository.findById(id).get().getProductList().add(product);
        product.setCustomer(customerRepository.findById(id).get());
        return modelMapper.map(productRepository.save(product), ProductDTO.class);
    }

}
