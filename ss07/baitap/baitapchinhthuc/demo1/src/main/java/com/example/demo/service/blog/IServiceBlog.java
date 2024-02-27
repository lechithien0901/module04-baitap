package com.example.demo.service.blog;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IServiceBlog {
    void addAndUpdate(Blog blog);
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findByAuthor(Pageable pageable,String nameAuthor);
    void  deleteBlog(Blog blog);
    Blog findBlog(Long id);
}
