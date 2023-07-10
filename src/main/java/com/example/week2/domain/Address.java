package com.example.week2.domain;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int addressId;

    @Column
    private String city, postalCode, street, country;

    @Column
    private int number;

    @OneToOne(mappedBy = "address")
    @JsonManagedReference
    private Customer customer;


}
