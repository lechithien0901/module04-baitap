package com.example.demo.controller;

import com.example.demo.model.CodeGymClass;
import com.example.demo.model.Student;
import com.example.demo.model.StudentDTO;
import com.example.demo.repository.student.IStudentRepository;
import com.example.demo.service.codegym_class.ICodegymClassService;
import com.example.demo.service.student.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/all")

public class StudentController {
    @Autowired
    private IStudentService iStudentService;

    @Autowired
    private ICodegymClassService iCodegymClassService;
    @Autowired
    private IStudentRepository iStudentRepository;

    @ModelAttribute("listClass")
    public List<CodeGymClass> showListCodegymClass() {
        return iCodegymClassService.showList();
    }

    @GetMapping("/list")
    public ResponseEntity<Page<Student>> showList(@RequestParam(defaultValue = "0", required = false) int page,
                                                  @RequestParam(defaultValue = "3", required = false) int pageSize,
                                                  Model model) {


        Sort sort = Sort.by("name").ascending();

        Pageable pageable = PageRequest.of(page, 4, sort);

        Page<Student> studentPage = iStudentService.findAll(pageable);

        int size = studentPage.getTotalPages();
        List<Integer> listPage = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            listPage.add(i);
        }

        model.addAttribute("pages", listPage);
        System.out.println(iStudentService.findAll(pageable));
        return new ResponseEntity<>(studentPage, HttpStatus.OK);

    }

    @GetMapping("/listParam")
    public ResponseEntity<List<Student>> showMyList(){
        List<Student> list=iStudentService.showList();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/show-form-create")
    public ModelAndView showFormCreate() {
        return new ModelAndView("/create", "student", new StudentDTO());
    }


    @PostMapping("/add")
    public ResponseEntity<?> addNewStudent(@Validated @RequestBody StudentDTO student, BindingResult bindingResult)  throws ChangeSetPersister.NotFoundException {
        new StudentDTO().validate(student, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST) ;

        }
        Student s = new Student();
        CodeGymClass codegymClass = iCodegymClassService.findById(student.getCodeGymClass().getId());

        BeanUtils.copyProperties(student, s);
        s.setCodeGymClass(codegymClass);
        iStudentService.addNewStudent(s);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}/delete")
    public String deleteStudent(@PathVariable Long id) {
        Student student = this.iStudentService.findStudent(id);
        this.iStudentService.deleteStudent(student);
        return "redirect:/all/list";
    }

    @GetMapping("/{id}/update")
    public String showUpdate(Model model, @PathVariable Long id) {


        model.addAttribute("student", new StudentDTO());
        model.addAttribute("student", this.iStudentService.findStudent(id));
        return "/update";


    }

    @PostMapping("/updateStudent")
    public String update(@Validated @ModelAttribute("student") StudentDTO studentDTO, BindingResult bindingResult) {

        new StudentDTO().validate(studentDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/update";

        }
        Student s = new Student();
        CodeGymClass codegymClass = iCodegymClassService.findById(studentDTO.getCodeGymClass().getId());
        BeanUtils.copyProperties(studentDTO, s);
        s.setCodeGymClass(codegymClass);
        iStudentService.edit(s);
        return "redirect:/all/list";
    }

}

