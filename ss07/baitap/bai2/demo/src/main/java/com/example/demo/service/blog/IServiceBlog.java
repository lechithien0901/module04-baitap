package com.example.demo.service.blog;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceBlog {
    List<Blog> showList();

    Blog findById(Long id);

    void addBlog(Blog blog);

    void deleteBlog(Blog blog);

    void edit(Blog blog);

    Page<Blog> findAll(Pageable pageable);

    Page<Blog>findByAuThor(Pageable pageable,String nameAuthor);
}
