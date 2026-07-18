package com.ecommerc.ecommerce_backend.controller;

import com.ecommerc.ecommerce_backend.entity.Product;
import com.ecommerc.ecommerce_backend.service.ProductService;
import com.zaxxer.hikari.metrics.PoolStats;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {

    @Autowired
    private final ProductService productService;

    //create product

    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product){

        Product savedProduct=productService.createProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

// Get All Products
@GetMapping public ResponseEntity<List<Product>> getAllProducts()
{
    return ResponseEntity.ok(productService.getAllProducts()); }


//get product by id

    @GetMapping("/{id}") public ResponseEntity<Product> getProductById(@PathVariable Long id)
    {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    //update product


    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id,@RequestBody Product product){

        return ResponseEntity.ok(productService.updateProduct(id,product));
    }

    //delete product

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully.");
    }

}
