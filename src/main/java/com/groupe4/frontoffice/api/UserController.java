package com.groupe4.frontoffice.api;

import com.groupe4.frontoffice.dto.UserDto;
import com.groupe4.frontoffice.model.user.User;
import com.groupe4.frontoffice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/registration")
    public String registration(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute UserDto user, Model model){
        model.addAttribute("user",user);
        return"Contact";
    }
}
