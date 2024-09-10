package com.example.blogs.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blogs.manager.CategoryManagement;
import com.example.blogs.model.Category;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryManagement categoryManagement;

    /**
     * Get all categories
     * 
     * @return Category[] List of categories
     */
    @GetMapping
    public ResponseEntity<List<Category>> getMethodName() {
        List<Category> categories = categoryManagement.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    /**
     * Create a new category
     * 
     * @param category category to be created
     * @return category created category
     */
    @PostMapping
    public ResponseEntity<Category> postMethodName(@RequestBody Category category) {
        Category createdCategory = categoryManagement.createCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    /**
     * Get a category by id
     * 
     * @param id
     * @return category category with the given id
     */
    @GetMapping("/{id}")
    public ResponseEntity<Category> getMethodName(@PathVariable UUID id) {
        Category updated = categoryManagement.getCategory(id);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    /**
     * Updatete a category
     * 
     * @param id       id of the category to be updated
     * @param category category to be updated
     * @return category updated category
     */
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable UUID id, @RequestBody Category category) {
        Category updated = categoryManagement.updateCategory(category, id);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    /**
     * Delete a category
     * 
     * @param id id of the category to be deleted
     * @return ResponseEntity<void> 204 No Content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable UUID id) {
        categoryManagement.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
