package com.example.demo.model;

public class Student {
    private Integer id;
    private String name;
    private Boolean gender;
    private String[] languages;

    public Student(Integer id, String name, Boolean gender, String[] languages) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.languages = languages;
    }

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }
}
