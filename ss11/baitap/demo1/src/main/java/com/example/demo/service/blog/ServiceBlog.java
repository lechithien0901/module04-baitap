package com.example.demo.service.blog;

import com.example.demo.model.Blog;
import com.example.demo.repository.blog.IRepositoryBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ServiceBlog implements IServiceBLog {
    @Autowired
    IRepositoryBlog iRepositoryBlog;
    @Override
    public Iterable<Blog> findAll() {
        return iRepositoryBlog.findAll();
    }

    @Override
    public Optional<Blog> findBlogById(Long id) {
        return iRepositoryBlog.findBlogById(id);
    }
}
