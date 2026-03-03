package com.example.demo.controller;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product createProduct(@Valid @RequestBody ProductDTO dto) {
        return productService.createProduct(dto);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/category/{categoryId}")
    public List<Product> getProductsByCategory(@PathVariable Long categoryId) {
        return productService.getProductsByCategory(categoryId);
    }

    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String name) {
        return productService.searchByName(name);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id,
                                 @Valid @RequestBody ProductDTO dto) {
        return productService.updateProduct(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "Product deleted successfully";
    }
}