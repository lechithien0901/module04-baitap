package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface IProductRepository extends PagingAndSortingRepository<Product,Long> {
   Iterable<Product> findAll();
   Optional<Product> findById(Long id);
}
