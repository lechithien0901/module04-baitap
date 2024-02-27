package vn.codegym.demo1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double salary;
    private String pDescribe;
    private String producer;

    public Product(long id, String name, double salary, String pDescribe, String producer) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.pDescribe = pDescribe;
        this.producer = producer;
    }

    public Product() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPDescribe() {
        return pDescribe;
    }

    public void setPDescribe(String pDescribe) {
        this.pDescribe = pDescribe;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", pDescribe='" + pDescribe + '\'' +
                ", producer='" + producer + '\'' +
                '}';
    }
}
