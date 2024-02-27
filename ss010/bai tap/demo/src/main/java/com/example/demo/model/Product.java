package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long maSp;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMaSp() {
        return maSp;
    }

    public void setMaSp(Long maSp) {
        this.maSp = maSp;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    private double salary;
    private double quantity;

    public Product(Long id, Long maSp, double salary, double quantity) {
        this.id = id;
        this.maSp = maSp;
        this.salary = salary;
        this.quantity = quantity;
    }
}
