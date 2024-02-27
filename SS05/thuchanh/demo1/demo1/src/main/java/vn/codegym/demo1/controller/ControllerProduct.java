package vn.codegym.demo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.codegym.demo1.model.Product;
import vn.codegym.demo1.service.IServiceProduct;

import java.util.List;

@Controller
@RequestMapping("/all")
public class ControllerProduct {
    @Autowired
    IServiceProduct iServiceProduct;

    @GetMapping("/showList")
    public String showList(Model model) {
        List<Product> list = this.iServiceProduct.showList();
        model.addAttribute("list", list);
        return "/show";
    }

    @GetMapping("/showAdd")
    public String showAdd(Model model) {
        model.addAttribute("product", new Product());
        return "/add";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product, Model model) {
        this.iServiceProduct.addProduct(product);
        model.addAttribute("message", "đối tượng đã được thêm mới");

        return "redirect:/all/showList";

    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") long id,Model model) {
        Product product=this.iServiceProduct.getProduct(id);
        model.addAttribute("product",product);
        return "/delete";
    }

    @PostMapping("/commitDelete")
    public String commitDelete(@ModelAttribute Product product) {
        this.iServiceProduct.deleteProduct(product.getId());
        return "redirect:/all/showList";
    }
    @GetMapping("/{id}/update")
    public String update(@PathVariable long id,Model model){
        model.addAttribute("product",this.iServiceProduct.getProduct(id));
        return "/update";


    }
    @PostMapping("/updateProduct")
    public String updateProduct(@ModelAttribute Product product){
        System.out.println(product);
        this.iServiceProduct.updateProduct(product);
        return "redirect:/all/showList";
    }
}
