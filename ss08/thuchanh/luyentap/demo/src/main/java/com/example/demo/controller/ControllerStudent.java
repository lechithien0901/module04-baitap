package com.example.demo.controller;

import com.example.demo.model.CodeGymClass;
import com.example.demo.model.Student;
import com.example.demo.model.StudentDTO;
import com.example.demo.service.codegym_class.ISeviceCodegymClass;
import com.example.demo.service.student.IServiceStudent;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/all")
public class ControllerStudent {
    @Autowired
    IServiceStudent iServiceStudent;
    @Autowired
    ISeviceCodegymClass iSeviceCodegymClass;

    @ModelAttribute("listCodeGym")
    public List<CodeGymClass> showListCodeGym() {
        return iSeviceCodegymClass.showList();
    }

    @GetMapping("/showList")
    public ModelAndView showListAll(@RequestParam(defaultValue = "0", required = false) int page, Model model) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<Student> studentPage = iServiceStudent.findAll(pageable);
        return new ModelAndView("/showList", "list", studentPage);


    }

    @GetMapping("/showAdd")
    public String showAdd(Model model) {
        model.addAttribute("student", new StudentDTO());
        return "/showCreate";

    }

    @PostMapping("/addStudent")
    public ModelAndView addStudent(@Validated @ModelAttribute("student") StudentDTO student,BindingResult bindingResult) {
        new StudentDTO().validate(student,bindingResult);
        if (bindingResult.hasErrors()){
            return new ModelAndView("/showCreate");
        }
        Student student1=new Student();
        CodeGymClass codeGymClass=iSeviceCodegymClass.findCodeGymClass(student.getCodeGymClass().getId());
        BeanUtils.copyProperties(student,student1);
        student1.setCodeGymClass(codeGymClass);
        iServiceStudent.add(student1);
        return new ModelAndView("redirect:/all/showList");




    }
}
