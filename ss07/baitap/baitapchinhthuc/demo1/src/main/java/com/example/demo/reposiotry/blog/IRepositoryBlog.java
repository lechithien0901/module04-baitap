package com.example.demo.reposiotry.blog;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryBlog extends JpaRepository<Blog,Long> {
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findByAuthor(Pageable pageable,String nameAuthor);
}
