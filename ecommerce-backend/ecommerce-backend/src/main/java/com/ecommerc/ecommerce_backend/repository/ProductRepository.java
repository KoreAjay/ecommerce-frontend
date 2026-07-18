package com.ecommerc.ecommerce_backend.repository;

import com.ecommerc.ecommerce_backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
