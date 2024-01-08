package com.example.demo1;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
@RequestMapping("/all")
public class Controller {
    @GetMapping("/show")
    public String showList(){
        return "/list";


    }@GetMapping("/listAll")
    public String addList(Model model,@RequestParam String[]spice){
        model.addAttribute("list",spice);
        return "/showList";
    }


}
