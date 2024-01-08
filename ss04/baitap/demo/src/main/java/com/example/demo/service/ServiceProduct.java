package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.IRepositoryProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ServiceProduct implements IServiceProduct {
    @Autowired
    IRepositoryProduct iRepositoryProduct;

    @Override
    public List<Product> listAll() {
        return iRepositoryProduct.listAll();
    }

    @Override
    public void addProduct(Product product) {
        iRepositoryProduct.addProduct(product);
    }

    @Override
    public void editProduct(int id, Product product) {
        iRepositoryProduct.editProduct(id,product);

    }

    @Override
    public void deleteProduct(int id) {
        iRepositoryProduct.deleteProduct(id);

    }
}
