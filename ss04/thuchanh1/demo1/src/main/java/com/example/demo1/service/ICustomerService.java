package com.example.demo1.service;

import com.example.demo1.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    void save(Customer customer);
     Customer findById(int id);
     void Update(int id,Customer customer);
     void remove(int id);

}
