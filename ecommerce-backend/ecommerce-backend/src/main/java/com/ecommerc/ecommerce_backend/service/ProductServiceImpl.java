package com.ecommerc.ecommerce_backend.service;

import com.ecommerc.ecommerce_backend.entity.Product;
import com.ecommerc.ecommerce_backend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    @Autowired
    private final ProductRepository productRepository;

    @Override
    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    @Override
    public Product getProductById(Long id)
    {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id :"+id));
    }

    @Override
    public Product updateProduct(Long id ,Product product)
    {
        Product existingProduct=getProductById(id);

        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setStock(product.getStock());
        existingProduct.setImageUrl(product.getImageUrl());

        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(Long id){
        Product product=getProductById(id);
        productRepository.delete(product);
    }


}
