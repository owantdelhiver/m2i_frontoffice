package com.groupe4.frontoffice.controller;

import com.groupe4.frontoffice.model.user.Adress;
import com.groupe4.frontoffice.model.user.User;
import com.groupe4.frontoffice.service.AdressService;
import com.groupe4.frontoffice.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    AdressService adressService;


    @GetMapping("/register")
    public String registration(
            Model model, User user, Adress adress){
        model.addAttribute("user", user);
        model.addAttribute("adress", adress);
        return "registration";
    }

    @PostMapping("/register")
    public String saveUser(User user, Adress adress){
        adressService.save(adress);
        user.setAdress(adress);
        userService.registerNewUserAccount(user);

        return"redirect:/login";
    }

}
