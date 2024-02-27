package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.blog.IServiceBlog;
import com.example.demo.service.category.IServiceCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/all")
public class ControllerBlog {
    @Autowired
    IServiceCategory iServiceCategory;
    @Autowired
    IServiceBlog iServiceBlog;

    @ModelAttribute("listCategory")
    public List<Category> getListCategory() {
        return this.iServiceCategory.showList();

    }
    @GetMapping("/showListOfMe")
    public ResponseEntity<List<Blog>> showListOfMe(){
        List<Blog> list=this.iServiceBlog.showList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/showList")
    public ModelAndView showList(@RequestParam(defaultValue = "0", required = false) int page,
                                 @RequestParam(defaultValue = "3", required = false) int pageSize, Model model) {
        Pageable pageable = PageRequest.of(page, 3);
        Page<Blog> blogPage = iServiceBlog.findAll(pageable);
        int size = blogPage.getTotalPages();
        List<Integer> listPage = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            listPage.add(i);
        }
        model.addAttribute("pages", listPage);
        return new ModelAndView("/showList", "list", blogPage);


    }

    @GetMapping("/addBlog")
    public String addTheBlog(Model model) {
        model.addAttribute("message", "Do You Want Add New");
        model.addAttribute("blog", new Blog());
        return "/add";
    }

    @PostMapping("/blogNew")
    public String realAddBlog(Model model, @ModelAttribute Blog blog) {
        this.iServiceBlog.addBlog(blog);
        return "redirect:/all/showList";
    }

    @GetMapping("/find")
    public ModelAndView findBlog(@RequestParam(defaultValue = "0", required = false) int page,
                                 @RequestParam String nameBlog,
                                 Model model) {
        Pageable pageable = PageRequest.of(page, 3);
        Page<Blog> blogPageAll=iServiceBlog.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView();
        if (nameBlog.equals("")){
            return new ModelAndView("/showList","list",blogPageAll);
        }

        Page<Blog> blogPage = iServiceBlog.findByAuThor(pageable, nameBlog);
        model.addAttribute("nameBlog",nameBlog);

        return new ModelAndView("/showList", "list", blogPage);


    }
}
