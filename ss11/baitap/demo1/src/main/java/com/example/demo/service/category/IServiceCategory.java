package com.example.demo.service.category;

import com.example.demo.model.Category;
import com.example.demo.repository.category.IRepositoryCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface IServiceCategory {
    Optional<Category> findById(Long id);
    Iterable<Category> findAll();
}
