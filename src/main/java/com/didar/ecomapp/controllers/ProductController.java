package com.didar.ecomapp.controllers;

import com.didar.ecomapp.dtos.CreateProductRequestDto;
import com.didar.ecomapp.models.Product;
import com.didar.ecomapp.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    private ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @PostMapping("/product")
    public Product createProduct(@RequestBody CreateProductRequestDto request){
        return null;

    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable("id") Long productId){
        return productService.getSingleProduct(productId);
    }
}
