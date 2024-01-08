package com.example.demo1.repository;

import com.example.demo1.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class RepositoryCustomer implements IRepositoryCustomer {
    private static final Map<Integer, Customer> customers;

    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1, "John", "john@codegym.vn", "Hanoi"));
        customers.put(2, new Customer(2, "Bill", "Bill@codegym.vn", "DaNang"));
        customers.put(3, new Customer(3, "Alex", "Alex@codegym.vn", "HoiAn"));
        customers.put(4, new Customer(4, "Adam", "Adam@codegym.vn", "Hue"));

    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(), customer);

    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public void Update(int id, Customer customer) {
        customers.put(id,customer);
    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }
}
