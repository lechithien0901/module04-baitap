package com.example.demo.repository;

import com.example.demo.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> listAll();
    void save(Student student);
    public List<Student> findByName(String keyword);
}
