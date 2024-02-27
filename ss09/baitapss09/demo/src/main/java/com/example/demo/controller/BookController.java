package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.model.BorrowerCode;
import com.example.demo.service.book.IBookService;
import com.example.demo.service.borrower_code.IBorrowerCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Random;

@Controller
@RequestMapping("/all")
public class BookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IBorrowerCodeService iBorrowerCodeService;

    @GetMapping("/list")
    public ModelAndView showList(@RequestParam(defaultValue = "0", required = false) int page, Model model) {
        Pageable pageable = PageRequest.of(page, 3);
        Page<Book> bookPage = iBookService.findAll(pageable);
        BorrowerCode borrowerCode = new BorrowerCode();
        model.addAttribute("b", borrowerCode);
        return new ModelAndView("/showList", "book", bookPage);
    }

    @GetMapping("/form-create")
    public ModelAndView showFormCreate() {
        return new ModelAndView("/create", "book", new Book());
    }

    @PostMapping("/create")
    public ModelAndView createBook(@ModelAttribute("book") Book book) {
        iBookService.addBook(book);
        return new ModelAndView("redirect:/all/list");

    }

    @GetMapping("/{id}/view")
    public ModelAndView showView(@PathVariable("id") Long id) {
        return new ModelAndView("/view", "book", iBookService.findByID(id));

    }

    @GetMapping("/{id}/borrow")
    public ModelAndView showBorrow(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) throws Exception {
        Book book = this.iBookService.findByID(id);
        BorrowerCode borrowerCode = new BorrowerCode();
        if (book.getBookQuantity() > 0) {
            borrowerCode.setBorrowerCode(randomBorrowerCode());
            borrowerCode.setBook(book);
            iBorrowerCodeService.addBorrowCode(borrowerCode);
            iBookService.reduceCode(id);
            String successfulMes = "your borrow code is " + borrowerCode.getBorrowerCode();
            redirectAttributes.addFlashAttribute("successfulMes", successfulMes);

        } else {
            throw new Exception();
        }
        return new ModelAndView("redirect:/all/{id}/view");


    }
    @GetMapping("/give-back")
    public ModelAndView giveBack(@RequestParam("code") String code,RedirectAttributes redirectAttributes){
        BorrowerCode borrowerCode =iBorrowerCodeService.findBorrowCode(code);
        if (borrowerCode!=null){
            Book book=borrowerCode.getBook();
            iBookService.increaseCode(book.getBookId());
            iBorrowerCodeService.deleteBorrowCode(borrowerCode);

        }else {
            String error_giveback="Borrow code"+code+"doesn't exits";
redirectAttributes.addFlashAttribute("error_giveback",error_giveback);
        }
        return new ModelAndView("redirect:/all/list");


    }

    @ExceptionHandler(Exception.class)
        public ModelAndView Error(){
        return new ModelAndView("/error");
    }




    private String randomBorrowerCode() {
        int codeLength = 5;
        StringBuilder sb = new StringBuilder(codeLength);
        Random random = new Random();

        do {
            for (int i = 0; i < codeLength; i++) {
                int randomNum = random.nextInt(10);
                sb.append(randomNum);
            }
        } while (iBorrowerCodeService.findBorrowCode(sb.toString()) != null);

        return sb.toString();
    }


}
