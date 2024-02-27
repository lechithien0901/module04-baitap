package com.example.demo.service.student;

import com.example.demo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IServiceStudent {
    Page<Student> findAll (Pageable pageable);
    void add(Student student);
    Student findStudentId(Long id);
    void delete(Student student);
}
