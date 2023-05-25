package com.groupe4.frontoffice.model.contact;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String email;
    private String message;

    public Ticket() {
    }

    public Ticket(int id, String email, String message) {
        this.id = id;
        this.email = email;
        this.message = message;
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
}
