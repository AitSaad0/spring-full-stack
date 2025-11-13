package com.spring_full_stack.spring.service.impl;

import com.spring_full_stack.spring.dto.ProductDto;
import com.spring_full_stack.spring.entity.Product;
import com.spring_full_stack.spring.repository.ProductRepository;
import com.spring_full_stack.spring.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> getProduct(){
        return productRepository.findAll().stream().map(this::transferToDto).collect(Collectors.toList());
    }

    public ProductDto transferToDto(Product product){
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product,productDto);
        return productDto;
    }
}
