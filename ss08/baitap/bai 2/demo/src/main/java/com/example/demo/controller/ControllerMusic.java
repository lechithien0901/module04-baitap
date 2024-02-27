package com.example.demo.controller;

import com.example.demo.model.Music;
import com.example.demo.model.MusicDTO;
import com.example.demo.service.IServiceMusic;
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
public class ControllerMusic {
    @Autowired
    IServiceMusic iServiceMusic;
    @GetMapping("/showList")
    public ModelAndView showAdd(@RequestParam(defaultValue = "0",required = false)int page){
        Pageable pageable=PageRequest.of(page,2);
        Page<Music> musicPage=iServiceMusic.findAll(pageable);
        return new ModelAndView("/showList","list",musicPage);

    }
    @GetMapping("/showAdd")
    public ModelAndView showAdd(){
        return new  ModelAndView("/showAdd","music",new MusicDTO());
    }
    @PostMapping("/addMusic")
    public ModelAndView addMusic(@Validated @ModelAttribute("music") MusicDTO music, BindingResult bindingResult){
        new MusicDTO().validate(music,bindingResult);
        if (bindingResult.hasErrors()){
            return new ModelAndView("/showAdd");
        }
        Music music1=new Music();
        BeanUtils.copyProperties(music,music1);
        iServiceMusic.addMusic(music1);
        return new ModelAndView("redirect:/all/showList");


    }
}
