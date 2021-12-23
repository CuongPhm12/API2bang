package com.codegym.api2bang.model;

import lombok.Data;

import javax.persistence.*;
@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long price;
    @ManyToOne
    @JoinColumn(name="producer_id")
    private Producer producer;



}
