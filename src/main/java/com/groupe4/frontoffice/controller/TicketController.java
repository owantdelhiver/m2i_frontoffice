package com.groupe4.frontoffice.controller;

import com.groupe4.frontoffice.model.contact.Ticket;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TicketController {

    @GetMapping(value = "/contact")
    public String ticket(Model model, Ticket ticket){
        model.addAttribute("ticket", ticket);;
        return "ticket";
    }
}
