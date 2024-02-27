package com.example.demo.service.codegym_class;

import com.example.demo.model.CodeGymClass;
import com.example.demo.repository.codegym_class.ICodegymClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CodegymClassService implements ICodegymClassService{
    @Autowired
    private ICodegymClassRepository iCodegymClassRepository;
    @Override
    public List<CodeGymClass> showList() {
        return iCodegymClassRepository.findAll();
    }

    @Override
    public CodeGymClass findById(Long id) {
        return iCodegymClassRepository.findById( id).orElse(null);
    }
}
