package com.example.demo.service.blog;

import com.example.demo.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IServiceBLog {
    Iterable<Blog> findAll();
    Optional<Blog> findBlogById(Long id);

}
