package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.IRepositoryProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceProduct implements IServiceProduct{
    @Autowired
    IRepositoryProduct iRepositoryProduct;
    @Override
    public Iterable<Product> findAll() {
        return iRepositoryProduct.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return iRepositoryProduct.findById(id);
    }
}
