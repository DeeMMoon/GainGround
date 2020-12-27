package com.gainground.gainGroung.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "profile_empl")
public class ProfileEmpl {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String first_name, last_name;
    private String locale, phoneNumber;
    private String age;
    private String information;
    private Long leafs;
    @OneToOne(mappedBy = "profileEmpl", cascade = CascadeType.ALL)
    private User profile;

    public ProfileEmpl() {
    }

    public ProfileEmpl(String first_name, String last_name, String locale, String age, String phoneNumber, User user) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.locale = locale;
        this.age = age;
        this.phoneNumber=phoneNumber;
        profile = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Long getLeafs() {
        return leafs;
    }

    public void setLeafs(Long leafs) {
        this.leafs = leafs;
    }

    public User getProfile() {
        return profile;
    }

    public void setProfile(User profile) {
        this.profile = profile;
    }
}