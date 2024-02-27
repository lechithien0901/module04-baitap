package vn.codegym.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.demo.model.Customer;
import vn.codegym.demo.repository.CustomerRepository;
import vn.codegym.demo.repository.ICustomerRepository;

import java.util.List;
@Service
public class CustomerService implements ICustomerService{

    ICustomerRepository iCustomerRepository=new CustomerRepository();
    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Customer findOne(long id) {
        return iCustomerRepository.findOne(id);
    }

    @Override
    public Customer save(Customer customer) {
        return iCustomerRepository.save(customer);
    }
}
