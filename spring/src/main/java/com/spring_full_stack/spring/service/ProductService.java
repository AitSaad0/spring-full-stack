package com.spring_full_stack.spring.service;

import com.spring_full_stack.spring.entity.Product;
import com.spring_full_stack.spring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getList(){
        return productRepository.findAll();
    }
}
