package com.example.demo.service.impl;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import com.example.demo.exception.CategoryNotFoundException;
import com.example.demo.exception.InvalidProductDataException;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(CategoryDTO dto) {

        if (categoryRepository.findByCategoryName(dto.getCategoryName()).isPresent()) {
            throw new InvalidProductDataException("Category name must be unique");
        }

        Category category = new Category();
        category.setCategoryName(dto.getCategoryName());
        category.setDescription(dto.getDescription());

        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found"));
    }

    @Override
    public Category updateCategory(Long id, CategoryDTO dto) {

        Category existing = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found"));

        if (!existing.getCategoryName().equals(dto.getCategoryName())) {
            if (categoryRepository.findByCategoryName(dto.getCategoryName()).isPresent()) {
                throw new InvalidProductDataException("Category name must be unique");
            }
        }

        existing.setCategoryName(dto.getCategoryName());
        existing.setDescription(dto.getDescription());

        return categoryRepository.save(existing);
    }

    @Override
    public void deleteCategory(Long id) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found"));

        categoryRepository.delete(category);
    }
}