package com.groupe4.frontoffice.api;

import com.groupe4.frontoffice.dto.UserDto;
import com.groupe4.frontoffice.model.user.Adress;
import com.groupe4.frontoffice.model.user.User;
import com.groupe4.frontoffice.service.AdressService;
import com.groupe4.frontoffice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    UserService userService;
    AdressService adressService;
    @GetMapping("/saveUser")
    public String registration(Model model, User user, Adress adress){
        model.addAttribute("user", new User());
        model.addAttribute("adress", new Adress());
        return "registration";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute User user,Adress adress, Model model){
        userService.save(user);
        adressService.save(adress);
        return"registration";
    }
}
