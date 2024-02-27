package vn.codegym.demo.service;

import vn.codegym.demo.model.Blog;

import java.util.List;

public interface IServiceRepository {
    List<Blog> showList();
    void addBlog(Blog blog);
    void deleteBlog(Blog blog);
    Blog findOne(int id);
    void updateBlog(Blog blog);
}
