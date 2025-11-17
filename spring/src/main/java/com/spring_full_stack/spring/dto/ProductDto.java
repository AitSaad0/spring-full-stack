package com.spring_full_stack.spring.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
public class ProductDto {

    @NotBlank
    @Size(min = 1, max = 10, message = "Id must be between 1 and 10")
    private Long productId;

    @NotBlank(message = "Name must not be blank")
    @Size(max = 30, message = "Name must not be have more than 30 character")
    private String name;

    @NotBlank
    @Size(min = 5, max = 100, message = "Description must be between 5 and 100")
    private String description;

    @NotBlank
    @Pattern(regexp = "^\\d{10}$", message = "Price must be digit")
    private BigDecimal price;


    private int popularity;
    private String imageUrl;
    private Instant createdAt;

}
