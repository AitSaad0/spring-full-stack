package com.spring_full_stack.spring.repository;

import com.spring_full_stack.spring.entity.Customer;
import com.spring_full_stack.spring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
