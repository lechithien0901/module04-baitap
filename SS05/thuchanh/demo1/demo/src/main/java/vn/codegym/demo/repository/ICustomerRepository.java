package vn.codegym.demo.repository;

import vn.codegym.demo.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();
    Customer findOne(long id);
    Customer save(Customer customer);
}
