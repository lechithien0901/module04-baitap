package com.example.demo.repository;

import com.example.demo.model.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer,Long> {
    Iterable<Customer> findAll();

    Optional<Customer> findById(Long id);
    @Transactional
    @Modifying

    Customer  save(Customer t);
    @Transactional
    @Modifying
    @Query("delete from Customer c where c.id=:id")
    void remove(Long id);



}
