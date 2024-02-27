package com.example.demo.service.codegym_class;

import com.example.demo.model.CodeGymClass;
import com.example.demo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ISeviceCodegymClass {
 List<CodeGymClass> showList();
 CodeGymClass findCodeGymClass(Long id);

}
