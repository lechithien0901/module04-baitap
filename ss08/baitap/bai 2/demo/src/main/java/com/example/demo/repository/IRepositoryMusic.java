package com.example.demo.repository;

import com.example.demo.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryMusic extends JpaRepository<Music,Long> {
    Page<Music> findAll(Pageable pageable);
}
