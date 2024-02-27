package com.example.demo.service.student;

import com.example.demo.model.Student;
import com.example.demo.repository.student.IRepositoryStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ServiceStudent implements IServiceStudent {
    @Autowired
    IRepositoryStudent iRepositoryStudent;

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return iRepositoryStudent.findAll(pageable);
    }

    @Override
    public void add(Student student) {
        iRepositoryStudent.save(student);

    }

    @Override
    public Student findStudentId(Long id) {
        return iRepositoryStudent.getReferenceById(id);
    }

    @Override
    public void delete(Student student) {
iRepositoryStudent.delete(student);
    }
}
