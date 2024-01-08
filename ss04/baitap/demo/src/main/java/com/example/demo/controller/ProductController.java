package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.IServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ALL")
public class ProductController {
    @Autowired
    IServiceProduct iServiceProduct;
    @GetMapping("/showList")
    public String showList(Model model){
        List<Product> list=this.iServiceProduct.listAll();

        model.addAttribute("list",list);
        return "/list";

    }
}
