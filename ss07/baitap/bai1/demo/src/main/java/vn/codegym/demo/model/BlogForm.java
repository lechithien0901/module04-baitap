package vn.codegym.demo.model;

import org.springframework.web.multipart.MultipartFile;

public class BlogForm {
    private Integer id;
    private String author;
    private String title;
    private String content;
    private MultipartFile img;

    public BlogForm(Integer id, String author, String title, String content, MultipartFile img) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.img = img;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }
}
