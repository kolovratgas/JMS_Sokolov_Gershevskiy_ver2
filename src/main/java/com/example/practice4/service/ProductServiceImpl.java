package com.example.practice4.service;

import com.example.practice4.dto.ProductDTO;
import com.example.practice4.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> getAll() {
        return productRepository.findAll().stream()
                .map(ProductDTO::new)
                .collect(Collectors.toList());
    }
}
