package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository

public class RepositoryProduct implements IRepositoryProduct {
    private static final Map<Integer, Product> listProduct;

    static {
        listProduct=new HashMap<>();
        listProduct.put(1, new Product(1, "Phone", 30000, "màu đen", "Sony"));
        listProduct.put(2, new Product(2, "Laptop", 30000, "màu vàng", "Phone"));
        listProduct.put(3, new Product(3, "Mac", 404000, "màu nâu ", "Laptop"));
    }

    @Override
    public List<Product> listAll() {
        return new ArrayList<>(listProduct.values());
    }

    @Override
    public void addProduct(Product product) {
        listProduct.put(product.getId(), product);

    }

    @Override
    public void editProduct(int id, Product product) {
        listProduct.put(id, product);
    }

    @Override
    public void deleteProduct(int id) {
        listProduct.remove(id);
    }
}
