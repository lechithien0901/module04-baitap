package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/all")
public class BasicCalculator {
    @GetMapping("/showList")
    public String showList(){
        return "/list";
    }
    @GetMapping("/math")
    public String calculatorMath(Model model,@RequestParam long value1, @RequestParam long value2, @RequestParam String operation){

        String stringOfMe=operation;
        long result;
        try {
            long rs1 = Long.parseLong(String.valueOf(value1));
            long rs2 = Long.parseLong(String.valueOf(value2));

            switch (stringOfMe){
                case "Addition(+)":
                    result=rs1+rs2;
                    break;
                case "Subtraction(-)":
                    result=rs1-rs2;
                    break;
                case "Multiplication(X)":
                    result=rs1*rs2;
                    break;
                case "Division(/)":
                    result=rs1/rs2;

                    break;
                default:
                    model.addAttribute("message","không tìm thấy phép tính của bạn cần");
                    return "/error";
            }
            model.addAttribute("result",result);

        }catch (NumberFormatException e){
            model.addAttribute("message","chuyển đổi giữa phép tính của bạn có vấn đề");
            return "/error";
        }catch (ArithmeticException e){
            model.addAttribute("message","phép chia không thể nào có mẫu bằng 0");
            return "/error";
        }

        return "/list";


    }
}
