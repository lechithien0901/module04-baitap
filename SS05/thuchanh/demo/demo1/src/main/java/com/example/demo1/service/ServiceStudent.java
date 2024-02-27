package com.example.demo1.service;

import com.example.demo1.model.Student;
import com.example.demo1.repository.IRepositoryStudent;
import com.example.demo1.repository.RepositoryStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceStudent implements IServiceStudent {
   @Autowired
    IRepositoryStudent iRepositoryStudent;

    @Override
    public List<Student> findAll() {
        return iRepositoryStudent.findAll();
    }

    @Override
    public void save(Student student) {
        iRepositoryStudent.save(student);
    }

    @Override
    public List<Student> findByName(String keyword) {
        return iRepositoryStudent.findByName(keyword);
    }
}
