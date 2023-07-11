package com.example.week2.domain;

import lombok.Data;

import java.util.List;

@Data
public class CustomerDTO {
        private int id;
        private String birthDate, email;
        private List<ProductDTO> productList;
}
