package com.groupe4.frontoffice.model.contact;

import com.groupe4.frontoffice.model.user.User;


public class Contact {
    private int id;
   private User user;
   private String extraInfo;

    public Contact() {
    }

    public Contact(int id, User user, String extraInfo) {
        this.id = id;
        this.user = user;
        this.extraInfo = extraInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }
}
