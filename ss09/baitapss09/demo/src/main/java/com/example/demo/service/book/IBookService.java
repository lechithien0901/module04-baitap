package com.example.demo.service.book;

import com.example.demo.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    void addBook(Book book);
    void reduceCode(Long id);
    void increaseCode(Long id);
    Book findByID(Long id);
    Page<Book> findAll(Pageable pageable);

}
