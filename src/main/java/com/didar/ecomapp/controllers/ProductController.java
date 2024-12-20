package com.didar.ecomapp.controllers;

import com.didar.ecomapp.dtos.CreateProductRequestDto;
import com.didar.ecomapp.models.Product;
import com.didar.ecomapp.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;
    public ProductController(@Qualifier("SelfProductService") ProductService productService){
        this.productService = productService;
    }
    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDto request){
        return productService.createProduct(
                request.getTitle(),
                request.getDescription(),
                request.getCategory(),
                request.getPrice(),
                request.getImage()
        );

    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable("id") Long productId){
        return productService.getSingleProduct(productId);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {

        List<Product> products = productService.getProducts();

//        throw new ProductNotFoundException("Bla bla bla");

        ResponseEntity<List<Product>> response = new ResponseEntity<>(products, HttpStatus.OK);
        return response;
    }
}
