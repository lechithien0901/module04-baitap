package com.example.demo.service.category;

import com.example.demo.model.Category;
import com.example.demo.repository.blog.IRepositoryBlog;
import com.example.demo.repository.category.IRepositoryCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceCategory implements IServiceCategory{
   @Autowired
    IRepositoryCategory iRepositoryCategory;
    @Override
    public List<Category> showList() {
        return iRepositoryCategory.findAll();
    }

    @Override
    public Category findById(Long id) {
        return iRepositoryCategory.getReferenceById(id);
    }
}
