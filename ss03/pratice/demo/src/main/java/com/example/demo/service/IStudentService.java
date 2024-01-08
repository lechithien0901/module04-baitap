package com.example.demo.service;

import com.example.demo.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> listAll();
    void save(Student student);
    public List<Student> findByName(String keyword);
}
