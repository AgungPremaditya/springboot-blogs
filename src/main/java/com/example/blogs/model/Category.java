package com.example.blogs.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Category {

    @Id
    @GeneratedValue()
    @Column(updatable = false, nullable = false)
    private UUID id;

    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Blog> blogs;

    // Getters and setters ID
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    // Getters and setters Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getters and setters Blogs
    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
