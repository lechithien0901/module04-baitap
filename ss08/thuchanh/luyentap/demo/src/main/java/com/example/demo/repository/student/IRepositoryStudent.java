package com.example.demo.repository.student;

import com.example.demo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryStudent extends JpaRepository<Student,Long> {
    Page<Student>findAll (Pageable pageable);
}
