package vn.codegym.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.demo.model.Blog;
import vn.codegym.demo.repostiory.blog.IBlogRepository;

import java.util.List;

@Service
public class ServiceRepository implements IServiceRepository {
    @Autowired
    IBlogRepository iBlogRepository;

    @Override
    public List<Blog> showList() {
        return iBlogRepository.findAll();
    }

    @Override
    public void addBlog(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void deleteBlog(Blog blog) {
        iBlogRepository.delete(blog);
    }

    @Override
    public Blog findOne(int id) {
        return iBlogRepository.getReferenceById(id);
    }

    @Override
    public void updateBlog(Blog blog) {
        iBlogRepository.save(blog);

    }
}
