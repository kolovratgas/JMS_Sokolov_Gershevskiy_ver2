package com.example.practice4.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "supplier")
@Table(name = "supplier")
@Data
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "INN")
    private String INN;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "supplier_product",
            joinColumns = @JoinColumn(name = "supplier_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;
}
