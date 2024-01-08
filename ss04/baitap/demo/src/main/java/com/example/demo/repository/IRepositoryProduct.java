package com.example.demo.repository;

import com.example.demo.model.Product;

import java.util.List;

public interface IRepositoryProduct {
    List<Product> listAll();
    void  addProduct(Product product);
    void editProduct(int id,Product product);
    void deleteProduct(int id);

}
