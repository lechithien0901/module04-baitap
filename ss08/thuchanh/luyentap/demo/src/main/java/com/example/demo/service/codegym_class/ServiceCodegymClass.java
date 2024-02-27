package com.example.demo.service.codegym_class;

import com.example.demo.model.CodeGymClass;
import com.example.demo.repository.codegym_class.IRepositoryCodeGymClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCodegymClass implements ISeviceCodegymClass{
    @Autowired
    IRepositoryCodeGymClass iRepositoryCodeGymClass;
    @Override
    public List<CodeGymClass> showList() {
        return iRepositoryCodeGymClass.findAll();
    }

    @Override
    public CodeGymClass findCodeGymClass(Long id) {
        return iRepositoryCodeGymClass.getReferenceById(id);
    }
}
