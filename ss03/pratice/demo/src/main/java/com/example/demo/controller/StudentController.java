package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    IStudentService iStudentService;

    @ModelAttribute("listLangues")
    public String[] showListLang() {
        return new String[]{"Java", "C#", "JS", "HTML"};

    }

    @GetMapping("/showList")
    public String showList(Model model) {
        List<Student> list = this.iStudentService.listAll();
        model.addAttribute("list", list);
        return "/showlist";
    }

    @GetMapping("/showAdd")
    public String showAdd(Model model) {
        Student student=new Student();
model.addAttribute("student",student);
        return "/showAdd";

    }

    @PostMapping("/add")
    public String add(@ModelAttribute Student student,RedirectAttributes redirectAttributes) {
        this.iStudentService.save(student);
        redirectAttributes.addFlashAttribute("msg","đối tượng của bạn đã được thêm mới");
        return "redirect:/student/showList";
    }

}
