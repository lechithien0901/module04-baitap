package com.example.demo.service.student;

import com.example.demo.model.Student;
import com.example.demo.repository.student.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository iStudentRepository;
    @Override
    public List<Student> showList() {
        return iStudentRepository.findAll();
    }

    @Override
    public void addNewStudent(Student student) {
        iStudentRepository.save(student);
    }

    @Override
    public void deleteStudent(Student student) {
        iStudentRepository.delete(student);
    }

    @Override
    public Student findStudent(Long id) {
        return iStudentRepository.getReferenceById(id);
    }

    @Override
    public void edit(Student student) {
        this.iStudentRepository.save(student);
    }

    @Override
    public Page<Student> findAll(Pageable pageable)  {
        return this.iStudentRepository.findAll(pageable);
    }
}
