package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService implements IStudentService{
    @Autowired
    IStudentRepository iStudentRepository;
    @Override
    public List<Student> listAll() {
        return iStudentRepository.listAll();
    }

    @Override
    public void save(Student student) {
iStudentRepository.save(student);
    }

    @Override
    public List<Student> findByName(String keyword) {
        return null;
    }
}
