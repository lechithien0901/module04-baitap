package com.example.demo.repository.codegym_class;

import com.example.demo.model.CodeGymClass;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryCodeGymClass extends JpaRepository<CodeGymClass,Long> {

}
