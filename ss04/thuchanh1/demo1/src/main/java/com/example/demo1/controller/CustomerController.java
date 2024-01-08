package com.example.demo1.controller;

import com.example.demo1.model.Customer;
import com.example.demo1.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ALL")
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;

    @GetMapping("/showList")
    public String showList(Model model) {
        List<Customer> customers = iCustomerService.findAll();
        model.addAttribute("customers", customers);
        return "index";
    }

    @GetMapping("showAdd")
    public String showAdd(Model model) {
        model.addAttribute("customer", new Customer());
        return "add";
    }

    @PostMapping("addCustomer")
    public String addCustomer(RedirectAttributes redirectAttributes, @ModelAttribute Customer customer) {
        System.out.println(customer);
        customer.setId((int)(Math.random()*1000));
        this.iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("message","đô tượng của bạn đã thêm mới thành công");
        return "redirect:/ALL/showList";
    }
    @GetMapping("{id}/edit")
    public String editCustomer(@PathVariable int id,Model model){
       model.addAttribute("customer",this.iCustomerService.findById(id));
       return "edit";


    }
    @PostMapping("/update")
    public String update(Customer customer){
        this.iCustomerService.Update(customer.getId(), customer);
        return "redirect:/ALL/showList";
    }
    @GetMapping("/{id}/delete")
    public String delete(Model model,@PathVariable int id){
        Customer customer=this.iCustomerService.findById(id);
        model.addAttribute("customer",customer);
        return "delete";


    }
    @PostMapping("/deleteList")
    public String deleteList(@ModelAttribute Customer customer){
        this.iCustomerService.remove(customer.getId());
        return "redirect:/ALL/showList";

    }
    @GetMapping("/{id}/view")
    public String view(Model model,@PathVariable int id){
        Customer customer=this.iCustomerService.findById(id);
        model.addAttribute("customer",customer);
        return "view";
    }



}
