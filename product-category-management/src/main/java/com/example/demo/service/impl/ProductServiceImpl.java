package com.example.demo.service.impl;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.entity.Category;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.ProductService;
import com.example.demo.exception.CategoryNotFoundException;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.exception.InvalidProductDataException;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository,
                              CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product createProduct(ProductDTO dto) {

        validateProduct(dto);

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException("Category not found"));

        Product product = new Product();
        product.setProductName(dto.getProductName());
        product.setPrice(dto.getPrice());
        product.setCategory(category);

        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, ProductDTO dto) {

        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));

        validateProduct(dto);

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException("Category not found"));

        existing.setProductName(dto.getProductName());
        existing.setPrice(dto.getPrice());
        existing.setCategory(category);

        return productRepository.save(existing);
    }

    @Override
    public void deleteProduct(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));

        productRepository.delete(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByCategory(Long categoryId) {

        if (!categoryRepository.existsById(categoryId)) {
            throw new CategoryNotFoundException("Category not found");
        }

        return productRepository.findByCategory_CategoryId(categoryId);
    }

    @Override
    public List<Product> searchByName(String name) {
        return productRepository.findByProductNameContaining(name);
    }

    private void validateProduct(ProductDTO dto) {

        if (dto.getProductName() == null || dto.getProductName().trim().isEmpty()) {
            throw new InvalidProductDataException("Product name must not be empty");
        }

        if (dto.getPrice() <= 0) {
            throw new InvalidProductDataException("Product price must be positive");
        }
    }
}