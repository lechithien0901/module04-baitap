package com.example.demo1.service;

import com.example.demo1.model.Customer;
import com.example.demo1.repository.IRepositoryCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    IRepositoryCustomer iRepositoryCustomer;

    @Override
    public List<Customer> findAll() {
        return iRepositoryCustomer.findAll();
    }

    @Override
    public void save(Customer customer) {
        iRepositoryCustomer.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return iRepositoryCustomer.findById(id);
    }

    @Override
    public void Update(int id, Customer customer) {
        iRepositoryCustomer.Update(id, customer);
    }

    @Override
    public void remove(int id) {
        iRepositoryCustomer.remove(id);
    }
}
