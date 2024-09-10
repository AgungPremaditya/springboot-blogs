package com.example.blogs.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.blogs.model.Category;
import com.example.blogs.service.CategoryService;

import java.util.UUID;
import java.util.List;

@Component
public class CategoryManagement {

    @Autowired
    private CategoryService categoryService;

    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    public Category createCategory(Category category) {
        return categoryService.saveCategory(category);
    }

    public Category getCategory(UUID categoryId) {
        return categoryService.findCategoryById(categoryId);
    }

    public Category updateCategory(Category category, UUID categoryId) {
        Category existingCategory = categoryService.findCategoryById(categoryId);
        if (existingCategory != null) {
            existingCategory.setName(category.getName());
            return categoryService.saveCategory(existingCategory);
        }

        return null;
    }

    public void deleteCategory(UUID categoryId) {
        categoryService.deleteCategory(categoryId);
    }
}