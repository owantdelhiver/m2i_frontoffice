package com.groupe4.frontoffice.api;

import com.groupe4.frontoffice.model.user.Adress;
import com.groupe4.frontoffice.model.user.User;
import com.groupe4.frontoffice.service.AdressService;
import com.groupe4.frontoffice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String registration(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("adress", new Adress());
        return "registration";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user,Adress adress){
        userService.save(user);
        adressService.save(adress);
        return"redirect:/registration";
    }

}
