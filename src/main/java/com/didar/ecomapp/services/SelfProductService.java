package com.didar.ecomapp.services;

import com.didar.ecomapp.models.Category;
import com.didar.ecomapp.models.Product;
import com.didar.ecomapp.repositories.CategoryRepository;
import com.didar.ecomapp.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("SelfProductService")
public class SelfProductService implements ProductService{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getSingleProduct(Long productId) {
        return productRepository.findByIdIs(productId);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(String title, String description, String category, Double price, String image) {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(image);

        Category categoryFromDatabase = categoryRepository.findByTitle(category);


        if (categoryFromDatabase == null) {
            Category newCategory = new Category();
            newCategory.setTitle(category);
//            categoryFromDatabase = categoryRepository.save(newCategory);
            categoryFromDatabase = newCategory;
//            category1 = new Category();
//            category1.setTitle(category);
        }

        // if the category was found from DB -> category1 will be having an ID
        // else: category1 won't have any ID
        product.setCategory(categoryFromDatabase);

        Product savedProduct = productRepository.save(product);

        return savedProduct;
    }
}
