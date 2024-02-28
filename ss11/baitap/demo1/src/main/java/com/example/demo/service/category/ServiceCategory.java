package com.example.demo.service.category;

import com.example.demo.model.Category;
import com.example.demo.repository.category.IRepositoryCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceCategory implements IServiceCategory {
    @Autowired
    IRepositoryCategory iRepositoryCategory;

    @Override
    public Optional<Category> findById(Long id) {
        return iRepositoryCategory.findById(id);
    }

    @Override
    public Iterable<Category> findAll() {
        return iRepositoryCategory.findAll();
    }
}
