package com.example.demo.service.category;

import com.example.demo.model.Category;

import java.util.List;

public interface IServiceCategory {
    Category findCategory(Long id);

    List<Category>showListCategory();

}
