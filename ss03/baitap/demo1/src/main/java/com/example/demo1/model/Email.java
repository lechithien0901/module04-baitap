package com.example.demo1.model;

import java.util.Arrays;

public class Email {
    private String[] languages;
    private String[] pageSize;
    private String Spam;
    private String Signature;

    public Email(String[] languages, String[] pageSize, String spam, String signature) {
        this.languages = languages;
        this.pageSize = pageSize;
        this.Spam = spam;
        Signature = signature;
    }

    public Email() {
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public String[] getPageSize() {
        return pageSize;
    }

    public void setPageSize(String[] pageSize) {
        this.pageSize = pageSize;
    }

    public String getSpam() {
        return Spam;
    }

    public void setSpam(String spam) {
        this.Spam = spam;
    }

    public String getSignature() {
        return Signature;
    }

    public void setSignature(String signature) {
        Signature = signature;
    }

    @Override
    public String toString() {
        return "Email{" +
                "languages=" + Arrays.toString(languages) +
                ", pageSize=" + Arrays.toString(pageSize) +
                ", spam='" + Spam + '\'' +
                ", Signature='" + Signature + '\'' +
                '}';
    }
}
