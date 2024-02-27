package vn.codegym.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.codegym.demo.model.Blog;
import vn.codegym.demo.service.IServiceRepository;

import java.util.List;

@Controller
@RequestMapping("/all")
public class BlogController {

    @Autowired
    IServiceRepository iServiceRepository;

    @GetMapping("/showList")
    public String showList(Model model) {
        List<Blog> list = iServiceRepository.showList();
        model.addAttribute("list", list);
        return "/list";
    }
    @GetMapping("/{id}/delete")
    public String showDelete(Model model, @PathVariable int id){
        Blog blog=this.iServiceRepository.findOne(id);
        model.addAttribute("blog",blog);
        model.addAttribute("message","Is this the object you want to delete");
        return "/delete";

    }
    @PostMapping("addBlog")
    public String addBlog(@ModelAttribute Blog blog){
        this.iServiceRepository.addBlog(blog);
        return "redirect:/all/showList";
    }
    @GetMapping("/add")
    public String showAdd(Model model){
        model.addAttribute("blog",new Blog());
        return "/add";

    }
    @PostMapping("/deleteBlog")
    public String deleteBlog(@ModelAttribute Blog blog){
        this.iServiceRepository.deleteBlog(blog);

        return "redirect:/all/showList";

    }
    @GetMapping("/{id}/update")
    public String showUpdate(Model model,@PathVariable int id){
        Blog blog=this.iServiceRepository.findOne(id);
        model.addAttribute("blog",blog);
        model.addAttribute("message","Is this the object you want to update");
        return "/update";

    }
    @PostMapping("/updateBlog")
    public String updateBlog(@ModelAttribute Blog blog){
        this.iServiceRepository.updateBlog(blog);
        return "redirect:/all/showList";

    }@GetMapping("/{id}/view")
    public String viewBlog(Model model,@PathVariable int id){
        Blog blog=this.iServiceRepository.findOne(id);
        model.addAttribute("blog", blog);
        model.addAttribute("message","Is this the object you want to update view");
        return "/view";
    }


}
