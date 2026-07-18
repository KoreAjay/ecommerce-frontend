package com.ecommerc.ecommerce_backend.service;

import com.ecommerc.ecommerce_backend.entity.Product;

import java.util.List;

public interface ProductService {
    public Product createProduct(Product product) ;

    public List<Product> getAllProducts() ;

    public Product getProductById(Long id) ;

    Product updateProduct(Long id, Product product);

    public void deleteProduct(Long id) ;

}
