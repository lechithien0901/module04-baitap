package com.example.demo.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String bookName;
    private String bookAuthor;
    private Long bookQuantity;

    public Book() {
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Long getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(Long bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public List<BorrowerCode> getBorrowerCodes() {
        return borrowerCodes;
    }

    public void setBorrowerCodes(List<BorrowerCode> borrowerCodes) {
        this.borrowerCodes = borrowerCodes;
    }

    public Book(Long bookId, String bookName, String bookAuthor, Long bookQuantity, List<BorrowerCode> borrowerCodes) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookQuantity = bookQuantity;
        this.borrowerCodes = borrowerCodes;
    }

    @OneToMany(mappedBy = "book")
    private List<BorrowerCode>borrowerCodes;


}
