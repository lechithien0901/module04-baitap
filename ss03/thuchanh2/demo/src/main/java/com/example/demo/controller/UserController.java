package com.example.demo.controller;

import com.example.demo.model.Login;
import com.example.demo.model.User;
import com.example.demo.service.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/show")
    public ModelAndView show(){
        ModelAndView modelAndView=new ModelAndView("show","login",new Login());
        return modelAndView;

    }
    @PostMapping("/showList")
    public String showList(@ModelAttribute Login login, Model model){
      User user=UserDao.checkUser(login);
      if (user!=null){
          model.addAttribute("user",user);
          return "/list";
      }else {
          model.addAttribute("message","Login error");
          return "/valuelist";

      }
      
    }
}
