package com.example.demo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
@RequestMapping("/list")
public class Controller {
    @GetMapping("/enterList")
    public String showList(){
        return "/list";
    }
    @GetMapping("/valueList")
    public String List(@RequestParam long value,Model model){
        long newValue=value*24000;
        model.addAttribute("value",newValue);
        return "/dollar";



    }

}
