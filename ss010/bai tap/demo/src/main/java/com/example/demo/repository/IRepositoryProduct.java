package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface IRepositoryProduct extends PagingAndSortingRepository<Product,Long> {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);

}
