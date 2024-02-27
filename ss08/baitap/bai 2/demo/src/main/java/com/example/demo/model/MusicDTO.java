package com.example.demo.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MusicDTO implements Validator {
    @Override
    public Errors validateObject(Object target) {
        return Validator.super.validateObject(target);
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    public static boolean validateNameMusic(String nameMusic) {
        String regex = "^[\\p{L}0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?\\s]{1,800}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nameMusic);
        return matcher.matches();
    }

    public static boolean validateNameMusicCharacters(String nameMusic) {
        String regex = "^[^!@#$%^&*(),.?\":{}|<>_+=\\-\\[\\]/]{1,800}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nameMusic);
        return matcher.matches();
    }

    @Override
    public void validate(Object target, Errors errors) {
        MusicDTO musicDTO = (MusicDTO) target;
        String nameMusic = musicDTO.getNameMusic();
        String artistsMusic = musicDTO.getArtists();
        String kindOfMusic = musicDTO.getKindOfMusic();
        if ("".equals(nameMusic)) {
            errors.rejectValue("nameMusic", "", "tên bài hát không được để trống");


        }
        if (!validateNameMusic(nameMusic)) {
            errors.rejectValue("nameMusic", "", "Tên bài hát dưới 800 kí tự ");
        }
        if (!validateNameMusicCharacters(nameMusic)) {
            errors.rejectValue("nameMusic", "", "tên bài hát không chứa các kí tự đặt biệt ");
        }


    }

    private Long id;
    private String nameMusic;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameMusic() {
        return nameMusic;
    }

    public void setNameMusic(String nameMusic) {
        this.nameMusic = nameMusic;
    }

    public String getArtists() {
        return artists;
    }

    public void setArtists(String artists) {
        this.artists = artists;
    }

    public MusicDTO() {
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    private String artists;
    private String kindOfMusic;

    public MusicDTO(Long id, String nameMusic, String artists, String kindOfMusic) {
        this.id = id;
        this.nameMusic = nameMusic;
        this.artists = artists;
        this.kindOfMusic = kindOfMusic;
    }
}
