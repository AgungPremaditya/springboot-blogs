package com.example.blogs.repository;

import com.example.blogs.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface BlogRepository extends JpaRepository<Blog, UUID> {
}
