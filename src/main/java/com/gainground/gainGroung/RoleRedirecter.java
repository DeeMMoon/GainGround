package com.gainground.gainGroung;

import com.gainground.gainGroung.entity.User;

import java.util.Iterator;

public class RoleRedirecter {
    public static String redirecter(User user, String page1, String page2){
        Iterator iterator = user.getRoles().iterator();
        String role = null;
        while(iterator.hasNext()){
            role = iterator.next().toString();
        }
        if(role.equals("ROLE_EMPLR")) return page1;
        if(role.equals("ROLE_EMPL")) return page2;
        else return "default";
    }
}
