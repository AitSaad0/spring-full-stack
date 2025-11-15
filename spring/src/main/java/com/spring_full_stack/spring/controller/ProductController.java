package com.spring_full_stack.spring.controller;


import com.spring_full_stack.spring.dto.ProductDto;
import com.spring_full_stack.spring.entity.Product;
import com.spring_full_stack.spring.service.IProductService;
import com.spring_full_stack.spring.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService iProductService;

    @GetMapping
    public List<ProductDto> getString(){
        List<ProductDto> productList = iProductService.getProduct();
        System.out.println("productList");
        return productList;
    }
}
