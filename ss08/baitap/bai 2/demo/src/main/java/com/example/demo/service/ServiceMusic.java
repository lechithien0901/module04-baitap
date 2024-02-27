package com.example.demo.service;

import com.example.demo.model.Music;
import com.example.demo.repository.IRepositoryMusic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ServiceMusic implements IServiceMusic{
    @Autowired
    IRepositoryMusic iRepositoryMusic;
    @Override
    public Page<Music> findAll(Pageable pageable) {
        return iRepositoryMusic.findAll(pageable);
    }

    @Override
    public void addMusic(Music music) {
        iRepositoryMusic.save(music);

    }

    @Override
    public void delete(Music music) {
        iRepositoryMusic.delete(music);

    }

    @Override
    public Music findMusicById(Long id) {
        return iRepositoryMusic.getReferenceById(id);
    }
}
