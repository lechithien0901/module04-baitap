package com.example.demo.repository.blog;

import com.example.demo.model.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface IRepositoryBlog extends PagingAndSortingRepository<Blog,Long> {
    Iterable<Blog> findAll();
    Optional<Blog> findBlogById(Long id);
}
