package com.example.demo.service.student;

import com.example.demo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    List<Student> showList();
    void addNewStudent(Student student);
    void deleteStudent(Student student);
    Student findStudent(Long id);
    void edit(Student student);
 Page<Student> findAll(Pageable pageable);



}
