package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.blog.IServiceBLog;
import com.example.demo.service.category.IServiceCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/all")
public class BlogController {
    @Autowired
    IServiceCategory iServiceCategory;
    @Autowired
    IServiceBLog iServiceBLog;

    @GetMapping("/showList")
    public ResponseEntity<List<Blog>> showList() {
        List<Blog> blogList = (List<Blog>) iServiceBLog.findAll();

        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/showCategory")
    public ResponseEntity<List<Category>> showListCategory() {
        List<Category> categoryList = (List<Category>) iServiceCategory.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/showListIdCategory/{id}")
    public ResponseEntity<List<Blog>> showListBlogWhereCategoryId(@PathVariable Long id) {
        Optional<Category> category = iServiceCategory.findById(id);


        if (!category.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Blog> blogList = category.get().getBlogs();
        return new ResponseEntity<>(blogList, HttpStatus.OK);

    }

    @GetMapping("/showListBlog/{id}")
    public ResponseEntity<Blog> showBlog(@PathVariable Long id) {
        Optional<Blog> blog = iServiceBLog.findBlogById(id);
        if (!blog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog.get(), HttpStatus.OK);

    }
}
