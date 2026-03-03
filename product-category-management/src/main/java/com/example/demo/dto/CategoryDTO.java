package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public class CategoryDTO {

    private Long categoryId;

    @NotBlank(message = "Category name must not be empty")
    private String categoryName;

    private String description;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}