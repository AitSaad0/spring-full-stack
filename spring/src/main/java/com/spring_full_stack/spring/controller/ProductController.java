package com.spring_full_stack.spring.controller;


import com.spring_full_stack.spring.entity.Product;
import com.spring_full_stack.spring.repository.ProductRepository;
import com.spring_full_stack.spring.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> getString(){
        List<Product> productList = productService.getList();
        return productList;
    }
}
