package com.ecommerc.ecommerce_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Value;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Product name is required")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Description required")
    @Column(nullable = false)
    private String description;

    @NotNull(message = "Price is required")
    @Min(value = 1, message = "Price must be greather then 0")
    @Column(nullable = false)
    private Double price;


    @NotBlank(message = "Category is required")
    @Column(nullable = false)
    private String category;

    @NotNull(message = "Stock is required")
    @Min(value = 0,message = "Stock cannot be negative")
    @Column(nullable = false)
    private Integer stock;

    private String imageUrl;


}
