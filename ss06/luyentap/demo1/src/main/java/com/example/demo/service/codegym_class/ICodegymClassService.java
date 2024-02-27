package com.example.demo.service.codegym_class;

import com.example.demo.model.CodeGymClass;

import java.util.List;

public interface ICodegymClassService {
    List<CodeGymClass> showList();
    CodeGymClass findById(Long id);



}
