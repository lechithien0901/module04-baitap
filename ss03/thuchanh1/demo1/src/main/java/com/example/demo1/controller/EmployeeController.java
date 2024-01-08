package com.example.demo1.controller;

import com.example.demo1.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @GetMapping("/showEmployee")
    public String showEmployee(Model model){
        model.addAttribute("employee",new Employee());
        return "list";
    }
    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("id",employee.getId());
        redirectAttributes.addFlashAttribute("name",employee.getName());
        redirectAttributes.addFlashAttribute("contactNumber",employee.getContactNumber());

        redirectAttributes.addFlashAttribute("message","đây là đối tượng Employee bạn vừa nhập");
        System.out.println(employee);
        return "show";
    }
}
