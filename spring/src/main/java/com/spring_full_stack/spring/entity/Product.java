package com.spring_full_stack.spring.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name="products")
public class Product {

    @Id
    @Column(name="product_id")
    private long productId;

    @Column(name="name",  nullable=false)
    private String name;

    @Column(name="description",  nullable=false)
    private String description;

    @Column(name="price",  nullable=false)
    private BigDecimal price;

    @Column(name="popularity",  nullable=false)
    private int popularity;

    private String imageUrl;

    @Column(name="created_at",  nullable=false)
    private Instant createdAt;

    @Column(name="created_by",  nullable=false)
    private String createdBy;

    private Instant updatedAt;
    private Instant updatedBy;

}
