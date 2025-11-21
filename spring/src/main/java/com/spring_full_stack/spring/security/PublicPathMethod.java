package com.spring_full_stack.spring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PublicPathMethod {

    @Bean
    public List<String> publicPaths() {
        return List.of(
                "/api/v1/products/**",
                "/api/v1/auth/**"
        );
    };

}