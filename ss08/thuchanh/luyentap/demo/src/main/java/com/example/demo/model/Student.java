package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @ManyToOne
    @JoinColumn(name = "codegym_class_name")

    private CodeGymClass codeGymClass;

    public Student() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCodeGymClass(CodeGymClass codeGymClass) {
        this.codeGymClass = codeGymClass;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public CodeGymClass getCodeGymClass() {
        return codeGymClass;
    }

    public Student(Long id, String name, String email, CodeGymClass codeGymClass) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.codeGymClass = codeGymClass;
    }
}
