package com.didar.ecomapp.services;

import com.didar.ecomapp.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long productId);

    List<Product> getProducts();

    Product createProduct(String title,
                          String description,
                          String category,
                          Double price,
                          String image);

}
