package com.example.demo.reposiotry.category;

import com.example.demo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryCategory extends JpaRepository<Category,Long> {

}
