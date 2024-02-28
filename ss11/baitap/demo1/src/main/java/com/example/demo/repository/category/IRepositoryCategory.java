package com.example.demo.repository.category;

import com.example.demo.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.Optional;
@Repository
public interface IRepositoryCategory extends PagingAndSortingRepository<Category,Long> {
    Optional<Category> findById(Long id);
    Iterable<Category> findAll();
}
