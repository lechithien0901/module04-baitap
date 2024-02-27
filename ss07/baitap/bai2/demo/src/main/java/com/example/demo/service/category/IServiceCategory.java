package com.example.demo.service.category;

import com.example.demo.model.Category;

import java.util.List;

public interface IServiceCategory {
    List<Category> showList();
    Category findById(Long id);
}
