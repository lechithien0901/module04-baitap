package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.IRepositoryProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface IServiceProduct {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);

}
