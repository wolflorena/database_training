package com.example.week2.application;

import com.example.week2.domain.Product;
import com.example.week2.domain.ProductDTO;

public interface ProductServiceInterface {
    abstract ProductDTO buyProduct(int id, Product product);
}
