package com.example.blogs.model;

import jakarta.persistence.*;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Blog {

    @Id
    @GeneratedValue()
    @Column(updatable = false, nullable = false)
    private UUID id;

    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties("blogs")
    private Category category;

    // Getters and setters ID
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    // Getters and setters Title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getters and setters Content
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Getters and setters Category
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
