package com.example.demo1.repository;

import com.example.demo1.model.Customer;

import java.util.List;

public interface IRepositoryCustomer {
    List<Customer> findAll();
    void save(Customer customer);
    Customer findById(int id);
    void Update(int id,Customer customer);
    void remove(int id);
}
