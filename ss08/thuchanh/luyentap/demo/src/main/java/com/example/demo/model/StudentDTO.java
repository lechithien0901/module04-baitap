package com.example.demo.model;

import jakarta.persistence.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentDTO implements Validator {
    @Override
    public Errors validateObject(Object target) {
        return Validator.super.validateObject(target);
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        StudentDTO studentDTO = (StudentDTO) target;
        String email = studentDTO.getEmail();
        String name = studentDTO.name;
        if ("".equals(email)) {
            errors.rejectValue("email", "", "khong duoc de trong");
        }
        if ("".equals(name)) {
            errors.rejectValue("name", "", "ten khong duoc de trong");
        }

    }

    private Long id;

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

    private String name;
    private String email;


    private CodeGymClass codeGymClass;

    public StudentDTO() {
    }

    public StudentDTO(Long id, String name, String email, CodeGymClass codeGymClass) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.codeGymClass = codeGymClass;
    }
}
