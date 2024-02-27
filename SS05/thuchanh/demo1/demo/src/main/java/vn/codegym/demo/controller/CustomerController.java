package vn.codegym.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.codegym.demo.model.Customer;
import vn.codegym.demo.service.CustomerService;
import vn.codegym.demo.service.ICustomerService;


import java.util.List;

@Controller
@RequestMapping("/all")
public class CustomerController {

    ICustomerService iCustomerService=new CustomerService();

    @GetMapping("/showList")
    public String showList(Model model) {
        List<Customer> list=this.iCustomerService.findAll();
        model.addAttribute("list",list);
        return "list";
    }

}
