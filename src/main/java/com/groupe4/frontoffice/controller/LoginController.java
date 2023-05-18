package com.groupe4.frontoffice.controller;

import com.groupe4.frontoffice.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    UserRepository userRepository;
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}