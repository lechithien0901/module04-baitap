package com.example.demo.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String auThor;
    private String title;
    private String content;
    private String img;

   private Date date;

    public Blog() {
    }

    public Blog(Long id, String auThor, String title, String content, String img, Date date, Category category) {
        this.id = id;
        this.auThor = auThor;
        this.title = title;
        this.content = content;
        this.img = img;
        this.date = date;
        this.category = category;
    }

    @ManyToOne
    @JoinColumn(name ="category_id")
   private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuThor() {
        return auThor;
    }

    public void setAuThor(String auThor) {
        this.auThor = auThor;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
