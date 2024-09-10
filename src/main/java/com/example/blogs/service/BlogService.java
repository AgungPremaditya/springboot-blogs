package com.example.blogs.service;

import com.example.blogs.model.Blog;
import com.example.blogs.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    public Blog findBlogById(UUID id) {
        return blogRepository.findById(id).orElse(null);
    }

    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    public void deleteBlog(UUID id) {
        blogRepository.deleteById(id);
    }
}
