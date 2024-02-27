package com.example.demo.repository.student;

import com.example.demo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface IStudentRepository extends JpaRepository<Student,Long> {
    Page<Student> findAll(Pageable pageable);

}
