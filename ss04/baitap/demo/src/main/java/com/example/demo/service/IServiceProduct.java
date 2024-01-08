package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;

public interface IServiceProduct {
    List<Product> listAll();
    void  addProduct(Product product);
    void editProduct(int id,Product product);
    void deleteProduct(int id);
}
