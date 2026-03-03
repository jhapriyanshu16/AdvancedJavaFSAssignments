package com.example.demo.service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import java.util.List;

public interface ProductService {

    Product createProduct(ProductDTO dto);

    List<Product> getAllProducts();

    List<Product> getProductsByCategory(Long categoryId);

    List<Product> searchByName(String name);

    Product updateProduct(Long id, ProductDTO dto);

    void deleteProduct(Long id);
}