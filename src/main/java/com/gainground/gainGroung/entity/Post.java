package com.gainground.gainGroung.entity;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Post  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userIdPost;
    private String title,anons,fullText;
    private int views;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public Post() {
    }

    public Post(String title, String anons, String fullText, User user) {
        this.title = title;
        this.anons = anons;
        this.fullText = fullText;
        this.author = user;
        userIdPost = user.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnons() {
        return anons;
    }

    public User getAuthor() {
        return author;
    }

    public Long getUserIdPost() {
        return userIdPost;
    }

    public void setUserIdPost(Long userId) {
        this.userIdPost = userId;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
