package com.groupe4.frontoffice.controller;

import com.groupe4.frontoffice.model.contact.Contact;
import com.groupe4.frontoffice.model.user.Adress;
import com.groupe4.frontoffice.model.user.User;
import com.groupe4.frontoffice.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {

    @Autowired
    ContactService contactService;

    @GetMapping("/contact")
    public String registration(Model model, Contact contact){
        model.addAttribute("contact", contact);;
        return "contact";
    }
    @PostMapping("/contact")
    public String userContact(Contact contact){

        contactService.saveContact(contact);

        return"redirect:/home";
    }
}
