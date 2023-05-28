package com.groupe4.frontoffice.model.contact;

public class Ticket {

    private int id;
    private String email;
    private String message;
    private String adminId;

    public Ticket() {
    }

    public Ticket(int id, String email, String message) {
        this.id = id;
        this.email = email;
        this.message = message;
    }

    public Ticket(int id, String email, String message, String adminId) {
        this.id = id;
        this.email = email;
        this.message = message;
        this.adminId = adminId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
}

