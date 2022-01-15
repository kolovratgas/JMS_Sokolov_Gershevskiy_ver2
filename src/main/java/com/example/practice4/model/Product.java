package com.example.practice4.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "product")
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private Integer code;

    @Column(name = "price")
    private Double price;

    @ManyToMany(mappedBy = "products")
    private List<Supplier> suppliers;
}
