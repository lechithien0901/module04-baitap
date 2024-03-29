package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class StudentRepository implements IStudentRepository{
    private static List<Student> studentList;
    static {
        studentList = new ArrayList<>();
        studentList.add(new Student(1, " Nguyen Van A", true, new String[]{"Java", "C#"}));
        studentList.add(new Student(2, " Nguyen Van B", false, new String[]{"C#"}));
        studentList.add(new Student(3, " Nguyen Van C", true, new String[]{"Java"}));
    }
    @Override
    public List<Student> listAll() {
        return studentList;
    }

    @Override
    public void save(Student student) {
        studentList.add(student);

    }

    @Override
    public List<Student> findByName(String keyword) {
        return null;
    }
}
