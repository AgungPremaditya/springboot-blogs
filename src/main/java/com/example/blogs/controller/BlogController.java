package com.example.blogs.controller;

import com.example.blogs.manager.BlogManagement;
import com.example.blogs.model.Blog;
import com.example.blogs.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private BlogManagement blogManagement;

    /**
     * Get all blogs
     * 
     * @return blog[] List of blogs
     */
    @GetMapping
    public List<Blog> getMethodName() {
        return blogService.getAllBlogs();
    }

    /**
     * Create a new blog
     * 
     * @param blog blog to be created
     * @return blog created blog
     */
    @PostMapping
    public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {
        Blog createdBlog = blogManagement.createBlog(blog);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBlog);
    }

    /**
     * Get a blog by id
     * 
     * @param id id of the blog to be retrieved
     * @return blog blog with the given id
     */
    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable UUID id) {
        Blog blog = blogManagement.getBlogDetail(id);
        if (blog != null) {
            return ResponseEntity.ok(blog);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    /**
     * Update a blog
     * 
     * @param id          id of the blog to be updated
     * @param updatedBlog blog with the updated fields
     * @return blog updated blog
     */
    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable UUID id, @RequestBody Blog updatedBlog) {
        Blog updated = blogService.updateBlog(id, updatedBlog);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    /**
     * Delete a blog
     * 
     * @param id id of the blog to be deleted
     * @return ResponseEntity<Void> 204 No Content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable UUID id) {
        blogService.deleteBlog(id);
        return ResponseEntity.noContent().build();
    }
}
