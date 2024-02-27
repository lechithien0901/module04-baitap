package com.example.demo1.service;

import com.example.demo1.model.Student;

import java.util.List;

public interface IServiceStudent {
    List<Student> findAll();
    void save(Student student);
    public List<Student> findByName(String keyword);
}
