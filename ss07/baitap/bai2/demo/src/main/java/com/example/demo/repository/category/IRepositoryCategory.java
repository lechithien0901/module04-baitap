package com.example.demo.repository.category;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryCategory extends JpaRepository<Category,Long> {


}
