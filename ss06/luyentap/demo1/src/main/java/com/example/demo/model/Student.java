package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @ManyToOne
//    @JsonBackReference
    @JoinColumn(name="studen_id")
    private CodeGymClass codeGymClass;

    public Student() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CodeGymClass getCodeGymClass() {
        return codeGymClass;
    }

    public void setCodeGymClass(CodeGymClass codeGymClass) {
        this.codeGymClass = codeGymClass;
    }

    public Student(Long id, String name, String email, CodeGymClass codeGymClass) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.codeGymClass = codeGymClass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", codeGymClass=" + codeGymClass +
                '}';
    }
}
