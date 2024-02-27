package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.blog.IServiceBlog;
import com.example.demo.service.category.IServiceCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/all")
public class ControllerBlog {
    @Autowired
    IServiceBlog iServiceBlog;
    @Autowired
   IServiceCategory iServiceCategory;
    @ModelAttribute("listCategory")
    public List<Category> showListCategory(){
        return iServiceCategory.showListCategory();
    }
    @GetMapping("/showList")
    public ModelAndView showList(@RequestParam(defaultValue = "0",required = false)int page){
        Sort sort=Sort.by("date").descending();
        Pageable pageable=PageRequest.of(page,3,sort);
        Page<Blog> blogPage=this.iServiceBlog.findAll(pageable);
        return new ModelAndView("/showList","list",blogPage);




    }
    @GetMapping("/find")
    public ModelAndView findList(@RequestParam(defaultValue = "0",required = false)int page, @RequestParam String nameBlog, Model model){
        Sort sort=Sort.by("date").ascending();
        Pageable pageable=PageRequest.of(page,3,sort);
        Page<Blog> blogPage=this.iServiceBlog.findAll(pageable);
        if (nameBlog.equals("")){
          return new ModelAndView("/showList","list",blogPage);
       }
         Page<Blog>blogPage1=this.iServiceBlog.findByAuthor(pageable,nameBlog);
        model.addAttribute("nameBlog",nameBlog);
        return new ModelAndView("/showList","list",blogPage1);
    }
    @GetMapping("/showAdd")
    public String showAdd(Model model ){
        model.addAttribute("blog",new Blog());
        return "/add";


    }
    @PostMapping("/addBlog")
    public String addBlog(@ModelAttribute ("blog") Blog blog){
        this.iServiceBlog.addAndUpdate(blog);
        return "redirect:/all/showList";

    }
}
