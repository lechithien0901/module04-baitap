package com.example.demo.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    Map<Product, Integer> productIntegerMap = new HashMap<>();

    public Cart(Map<Product, Integer> productIntegerMap) {
        this.productIntegerMap = productIntegerMap;
    }

    public Cart() {
    }

    public Map<Product, Integer> getProductIntegerMap() {
        return productIntegerMap;
    }

    public void setProductIntegerMap(Map<Product, Integer> productIntegerMap) {
        this.productIntegerMap = productIntegerMap;
    }

    public boolean checkProduct(Product product) {
        for (Map.Entry<Product, Integer> entry : productIntegerMap.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return true;
            }
        }
        return false;
    }

    public Map.Entry<Product, Integer> selectProduct(Product product) {
        for (Map.Entry<Product, Integer> entry : productIntegerMap.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        if (!checkProduct(product)) {
            productIntegerMap.put(product, 1);
        } else {
            Map.Entry<Product, Integer> entry = this.selectProduct(product);
            Integer newCount = entry.getValue()+1;
            productIntegerMap.put(entry.getKey(), newCount);
        }

    }

    public Integer sizeProduct() {
        return productIntegerMap.size();
    }

    public Integer CountProductQuality() {
        Integer product = 0;
        for (Map.Entry<Product, Integer> entry : productIntegerMap.entrySet()) {
            product += entry.getValue();
        }
        return product;

    }

    public float salaryProduct() {
        float count=0;
        for (Map.Entry<Product,Integer>productIntegerEntry:productIntegerMap.entrySet()){
            count+=productIntegerEntry.getKey().getSalary() * (float) productIntegerEntry.getValue();
        }
        return count;

    }
}
