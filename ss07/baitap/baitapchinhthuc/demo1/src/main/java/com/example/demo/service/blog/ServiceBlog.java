package com.example.demo.service.blog;

import com.example.demo.model.Blog;
import com.example.demo.reposiotry.blog.IRepositoryBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ServiceBlog implements IServiceBlog{
    @Autowired
    IRepositoryBlog iRepositoryBlog;
    @Override
    public void addAndUpdate(Blog blog) {
        iRepositoryBlog.save(blog);


    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iRepositoryBlog.findAll(pageable);
    }

    @Override
    public Page<Blog> findByAuthor(Pageable pageable, String nameAuthor) {
        return iRepositoryBlog.findByAuthor(pageable,nameAuthor) ;
    }

    @Override
    public void deleteBlog(Blog blog) {
        iRepositoryBlog.delete(blog);

    }

    @Override
    public Blog findBlog(Long id) {
        return iRepositoryBlog.getReferenceById(id);
    }
}
