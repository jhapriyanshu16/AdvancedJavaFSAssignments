package com.example.demo.service;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.entity.Category;
import java.util.List;

public interface CategoryService {

    Category createCategory(CategoryDTO dto);

    List<Category> getAllCategories();

    Category getCategoryById(Long id);

    Category updateCategory(Long id, CategoryDTO dto);

    void deleteCategory(Long id);
}