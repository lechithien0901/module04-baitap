package com.example.demo.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentDTO implements Validator {
    private Long id;
    private String name;
    @NotBlank(message = "email cua ban da bị để trống")
    private String email;

    public StudentDTO() {
    }

    public StudentDTO(Long id, String name, String email, CodeGymClass codeGymClass) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.codeGymClass = codeGymClass;
    }

    public StudentDTO(String name, String email, CodeGymClass codeGymClass) {
        this.name = name;
        this.email = email;
        this.codeGymClass = codeGymClass;
    }


    private CodeGymClass codeGymClass;

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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        StudentDTO studentDTO = (StudentDTO) target;
        String email = studentDTO.getEmail();
        String name = studentDTO.getName();

        if ("".equals(email))
            errors.rejectValue("email", "", "Can not be empty");

        else if (email.equals("1"))
            errors.rejectValue("email", "", "ban khong duoc nhap so 1");
        if ("".equals(name))
            errors.rejectValue("name", "", "name cua ban khong duoc de trống");

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

