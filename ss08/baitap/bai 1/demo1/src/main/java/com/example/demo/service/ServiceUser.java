package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.IRepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ServiceUser implements IServiceUser {
    @Autowired
    IRepositoryUser iRepositoryUser;

    @Override
    public Page<User> findAll(Pageable pageable) {
        return iRepositoryUser.findAll(pageable);
    }

    @Override
    public void add(User user) {
        iRepositoryUser.save(user);
    }

    @Override
    public User findUser(Long id) {
        return iRepositoryUser.getReferenceById(id);
    }

    @Override
    public void deleteUser(User user) {
        iRepositoryUser.delete(user);
    }
}
