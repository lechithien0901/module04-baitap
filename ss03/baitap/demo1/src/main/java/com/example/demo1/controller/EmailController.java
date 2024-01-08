package com.example.demo1.controller;

import com.example.demo1.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/all")
public class EmailController {
    @ModelAttribute("languagesList")
    public String[] showLanguages(){
        return new String[]{"Englist","Vietnamese","Japanese","Chinese"};
    }
    @ModelAttribute("pageSize")
    public String[] showPageSize(){
        return new String[]{"5","10","15","20","25","50","100"};
    }
    @GetMapping("/show")
    public ModelAndView showEmail(){
        ModelAndView modelAndView=new ModelAndView("/list","email",new Email());
        return modelAndView;
    }
    @PostMapping("/add")
    public String showAdd(@ModelAttribute Email email,Model model){
        model.addAttribute("email",email);
        model.addAttribute("message","chúc mừng bạn đã thêm được một hộp thư email");
        return "/add";
    }

}
