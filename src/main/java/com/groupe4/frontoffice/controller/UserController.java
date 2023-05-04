package com.groupe4.frontoffice.controller;

import com.groupe4.frontoffice.model.user.User;
import com.groupe4.frontoffice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public void getUserList(Model model) {
        List<User> users = userService.fetchAll();
        System.out.println(users.get(0).getFirstname());
    }
}