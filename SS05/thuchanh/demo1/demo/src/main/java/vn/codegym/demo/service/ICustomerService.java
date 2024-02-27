package vn.codegym.demo.service;

import vn.codegym.demo.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Customer findOne(long id);
    Customer save(Customer customer);
}
