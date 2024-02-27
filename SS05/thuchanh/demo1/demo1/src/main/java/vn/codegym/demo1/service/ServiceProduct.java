package vn.codegym.demo1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.demo1.model.Product;
import vn.codegym.demo1.repository.IRepositoryProduct;

import java.util.List;

@Service
public class ServiceProduct implements IServiceProduct {
    @Autowired
    IRepositoryProduct iRepositoryProduct;

    @Override
    public List<Product> showList() {
        return iRepositoryProduct.showList();
    }

    @Override
    public void addProduct(Product product) {
        iRepositoryProduct.addProduct(product);

    }

    @Override

    public void updateProduct(Product product) {
        iRepositoryProduct.updateProduct(product);

    }

    @Override
    public void deleteProduct(long id) {
        this.iRepositoryProduct.deleteProduct(id);
    }

    @Override
    public Product getProduct(long id) {
        return this.iRepositoryProduct.getProduct(id);
    }
}
