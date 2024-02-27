package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class BorrowerCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long borrowerCodeId;
    @Column(unique = true)
    private String borrowerCode;
    @ManyToOne
    private Book book;

    public BorrowerCode() {
    }

    public Long getBorrowerCodeId() {
        return borrowerCodeId;
    }

    public void setBorrowerCodeId(Long borrowerCodeId) {
        this.borrowerCodeId = borrowerCodeId;
    }

    public String getBorrowerCode() {
        return borrowerCode;
    }

    public void setBorrowerCode(String borrowerCode) {
        this.borrowerCode = borrowerCode;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BorrowerCode(Long borrowerCodeId, String borrowerCode, Book book) {
        this.borrowerCodeId = borrowerCodeId;
        this.borrowerCode = borrowerCode;
        this.book = book;
    }
}
