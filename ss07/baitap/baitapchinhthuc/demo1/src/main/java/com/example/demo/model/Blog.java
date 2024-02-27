package com.example.demo.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String title;
    private String content;

    public Blog(Long id, String author, String title, String content, Category category, String img, Date date) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.category = category;
        this.img = img;

        this.date = date;
    }
    @ManyToOne
    @JoinColumn(name ="category_id")


    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Blog() {
    }

    private String img;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public Blog(Long id, String author, String title, String content, String img, Date date) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.img = img;
        this.date = date;
    }
}
