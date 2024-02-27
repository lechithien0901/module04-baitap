package com.example.demo1.repository;

import com.example.demo1.model.Student;

import java.util.List;

public interface IRepositoryStudent {
    List<Student> findAll();
    void save(Student student);
    public List<Student> findByName(String keyword);
}
