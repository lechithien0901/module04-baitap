package com.example.demo.service.book;

import com.example.demo.model.Book;
import com.example.demo.repository.book.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    IBookRepository iBookRepository;
    @Override
    public void addBook(Book book) {
        if (book!=null){
            iBookRepository.save(book);
        }


    }

    @Override
    public void reduceCode(Long id) {
        iBookRepository.reduceCode(id);

    }

    @Override
    public void increaseCode(Long id) {
        iBookRepository.increaseCode(id);

    }

    @Override
    public Book findByID(Long id) {
      Optional<Book>optionalBook=this.iBookRepository.findById(id);
      Book book=null;
      if (optionalBook.isPresent()){
          book=optionalBook.get();

      }
      return book;
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return iBookRepository.findAll(pageable);
    }
}
