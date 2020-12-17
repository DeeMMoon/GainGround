package com.gainground.gainGroung.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@Table(name = "profile_empl")
public class ProfileEmpl {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String first_name, last_name;
    private String locale, phoneNumber;
//    @JsonFormat(pattern="dd/MM/yyyy")
//    @NonNull
//    private Date age;
    private Integer leafs;
    @OneToOne(mappedBy = "profileEmpl", cascade = CascadeType.ALL)
    private User profile;

    public ProfileEmpl() {
    }

    public ProfileEmpl(String first_name, String last_name, String locale, Date age, String phoneNumber, User user) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.locale = locale;
        //this.age = age;
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

//    public Date getAge() {
//        return age;
//    }
//
//    public void setAge(Date age) {
//        this.age = age;
//    }

    public User getProfile() {
        return profile;
    }

    public void setProfile(User profile) {
        this.profile = profile;
    }

    public int getLeafs() {
        return leafs;
    }

    public void setLeafs(Integer leafs) {
        this.leafs = leafs;
    }
}