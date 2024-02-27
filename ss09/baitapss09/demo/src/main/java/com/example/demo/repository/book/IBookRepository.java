package com.example.demo.repository.book;

import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {
    @Transactional
    @Modifying
    @Query("update Book b set b.bookQuantity=b.bookQuantity-1 where b.bookId= :id")
    void reduceCode(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("update Book b set b.bookQuantity=b.bookQuantity+1 where b.bookId=:id")
    void increaseCode(@Param("id")Long id);

}
