package com.spring_full_stack.spring.service;

import com.spring_full_stack.spring.dto.ProductDto;
import com.spring_full_stack.spring.entity.Product;

import java.util.List;

public interface IProductService {
    public List<ProductDto> getProduct();
}
