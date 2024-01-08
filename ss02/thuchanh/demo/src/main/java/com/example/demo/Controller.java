package com.example.demo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@org.springframework.stereotype.Controller
@RequestMapping("/all")
public class Controller {
    @GetMapping("/world-clock")
    public String getTimeByTimezone(Model model,@RequestParam(name = "city",required = false,defaultValue = "Asia/Ho_Chi_Minh") String city){
        Date date=new Date();
        TimeZone local=TimeZone.getDefault();
        TimeZone locale=TimeZone.getTimeZone(city);
        long locale_Time=date.getTime()+(locale.getRawOffset()-local.getRawOffset());
        date.setTime(locale_Time);
        model.addAttribute("city", city);
        model.addAttribute("date", date);
        return "list";
    }


}
