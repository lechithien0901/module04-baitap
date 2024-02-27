package vn.codegym.demo.repostiory.blog;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.demo.model.Blog;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {

}
