package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IServiceUser {
    Page<User> findAll(Pageable pageable);
    void add(User user);
    User findUser(Long id);
    void deleteUser(User user);

}
