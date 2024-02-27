package com.example.demo1.controller;

import com.example.demo1.model.Student;
import com.example.demo1.service.IServiceStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequestMapping("/All")
@Controller
public class StudentController {
    @Autowired
    private IServiceStudent iServiceStudent;
    @ModelAttribute("listLanguage")
    public String[] showListLanguage(){
        return new String[]{"Java", "C#", "JS"};
    }

    @GetMapping("/showList") // URL handle mapping
    public String showList1(Model model) { // handle method
        List<Student> studentList = iServiceStudent.findAll();
        model.addAttribute("studentList", studentList);
        return "list";
    }


    @GetMapping("/showFormCreate")
    public String showFormCreate(Model model) {
        model.addAttribute("student", new Student());
        return "create";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("student") Student student,
                      RedirectAttributes redirectAttributes) {
        iServiceStudent.save(student);
        redirectAttributes.addFlashAttribute("msg","Successfully");
        return "redirect:/All/showList";
    }
}
