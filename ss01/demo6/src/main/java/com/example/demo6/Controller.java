package com.example.demo6;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/list")
public class Controller {
    @GetMapping("/1")
    public String list(){
      return "list";
    }


}
