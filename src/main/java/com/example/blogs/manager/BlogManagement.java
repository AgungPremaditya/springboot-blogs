package com.example.blogs.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.blogs.model.Blog;
import com.example.blogs.service.BlogService;
import com.example.blogs.service.CategoryService;

import java.util.UUID;

@Component
public class BlogManagement {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    public Blog getBlogDetail(UUID blogId) {
        return blogService.findBlogById(blogId);
    }

    public Blog createBlog(Blog blogPayload) {
        // Set category
        var category = categoryService.findCategoryById(blogPayload.getCategory().getId());
        blogPayload.setCategory(category);

        // Save blog
        return blogService.saveBlog(blogPayload);
    }

    public Blog updateBlog(Blog blogPayload, UUID blogId) {
        // Set category
        var category = categoryService.findCategoryById(blogPayload.getCategory().getId());
        blogPayload.setCategory(category);

        // Update Blog
        Blog existingBlog = blogService.findBlogById(blogId);
        if (existingBlog != null) {
            existingBlog.setTitle(blogPayload.getTitle());
            existingBlog.setContent(blogPayload.getContent());
            return blogService.saveBlog(existingBlog);
        }

        return null;
    }
}
