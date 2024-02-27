package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.UserDto;
import com.example.demo.service.IServiceUser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/all")
public class ControllerUser {
    @Autowired
    IServiceUser iServiceUser;

    @GetMapping("/showList")
    public ModelAndView showList(@RequestParam(defaultValue = "0", required = false) int page) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<User> userPage = this.iServiceUser.findAll(pageable);
        return new ModelAndView("/showList", "list", userPage);


    }
    @GetMapping("/showAdd")
    public ModelAndView showAdd(){
        return new ModelAndView("/showAdd","user",new UserDto());

    }
    @PostMapping("/addUser")
    public ModelAndView addUser(@Validated @ModelAttribute("user") UserDto user, BindingResult bindingResult){
        new UserDto().validate(user,bindingResult);
        if (bindingResult.hasErrors()){
            return new ModelAndView("/showAdd");
        }
        User user1=new User();
        BeanUtils.copyProperties(user,user1);
        iServiceUser.add(user1);
        return new ModelAndView("redirect:/all/showList");

    }
}
