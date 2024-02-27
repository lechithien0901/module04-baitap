package com.example.demo.service;

import com.example.demo.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IServiceMusic {
    Page<Music> findAll(Pageable pageable);
    void addMusic(Music music);
    void delete(Music music);
    Music  findMusicById(Long id);

}
