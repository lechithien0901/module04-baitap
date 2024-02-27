package com.example.demo.service.category;

import com.example.demo.model.Category;
import com.example.demo.reposiotry.category.IRepositoryCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCategory implements IServiceCategory {
@Autowired
    IRepositoryCategory iRepositoryCategory;

    @Override
    public Category findCategory(Long id) {
        return iRepositoryCategory.getReferenceById(id);
    }

    @Override
    public List<Category> showListCategory() {
        return iRepositoryCategory.findAll();
    }
}
