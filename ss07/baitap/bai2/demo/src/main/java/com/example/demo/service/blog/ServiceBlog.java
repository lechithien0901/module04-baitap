package com.example.demo.service.blog;

import com.example.demo.model.Blog;
import com.example.demo.repository.blog.IRepositoryBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceBlog implements IServiceBlog {
    @Autowired
    IRepositoryBlog iRepositoryBlog;

    @Override
    public List<Blog> showList() {
        return iRepositoryBlog.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return iRepositoryBlog.getReferenceById(id);
    }

    @Override
    public void addBlog(Blog blog) {
        iRepositoryBlog.save(blog);

    }


    @Override
    public Page<Blog> findByAuThor(Pageable pageable, String nameAuthor) {
        return iRepositoryBlog.findByAuThor(pageable,nameAuthor);
    }

    @Override
    public void deleteBlog(Blog blog) {
        iRepositoryBlog.delete(blog);

    }

    @Override
    public void edit(Blog blog) {
       iRepositoryBlog.save(blog);

    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iRepositoryBlog.findAll(pageable);
    }
}
