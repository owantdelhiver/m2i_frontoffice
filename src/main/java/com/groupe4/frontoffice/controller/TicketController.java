package com.groupe4.frontoffice.controller;

import com.groupe4.frontoffice.model.contact.Ticket;
import com.groupe4.frontoffice.model.user.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TicketController extends SuperController {

    @GetMapping(value = {"/contact","/ticket"})
    public String ticket(Model model, Ticket ticket, HttpSession session){
        User user = super.getUserSession(session);
        model.addAttribute("user", user);;
        model.addAttribute("ticket", ticket);;
        return "ticket";
    }
}
