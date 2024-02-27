package vn.codegym.demo1.repository;

import vn.codegym.demo1.model.Product;

import java.util.List;

public interface IRepositoryProduct {
    List<Product> showList();
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(long id);
    Product getProduct(long id);

}
