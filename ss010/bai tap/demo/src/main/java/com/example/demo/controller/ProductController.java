package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.service.IServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    IServiceProduct iServiceProduct;
    @ModelAttribute("cart")
    public Cart setCart(){
        return new Cart();
    }
    @GetMapping("/showList")
    public ModelAndView showList(){
        return new ModelAndView("/showList","product",iServiceProduct.findAll());

    }
    @GetMapping("/showAdd/{id}")
    public ModelAndView showAdd(@PathVariable Long id,@ModelAttribute Cart cart, @RequestParam("action") String action){
        Optional<Product> productOptional=this.iServiceProduct.findById(id);
       if (!productOptional.isPresent()){
           return new ModelAndView("/error");
       }
       if (action.equals("list")){
           Product product=productOptional.get();


           return new ModelAndView("/view","product",product);
       }
      if (action.equals("showCart")){
          cart.addProduct(productOptional.get());
          return new ModelAndView("redirect:/shopping-cart");

      }
      cart.addProduct(productOptional.get());
      return new ModelAndView("redirect:/showList");
    }
}
