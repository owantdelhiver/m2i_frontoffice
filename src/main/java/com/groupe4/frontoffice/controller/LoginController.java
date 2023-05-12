package com.groupe4.frontoffice.controller;

import com.groupe4.frontoffice.model.user.User;
import com.groupe4.frontoffice.repository.user.UserRepository;
import com.groupe4.frontoffice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    UserRepository userRepository;
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

//    @PostMapping("/login")
//    public String processLogin(@RequestParam("email") String email,
//                               @RequestParam("password") String password,
//                               RedirectAttributes redirectAttributes) {
//
//        Optional<User> userOptional = userRepository.findByEmail(email);
//        if (userOptional.isPresent()) {
//            User user = userOptional.get();
//            if (user.getPassword().equals(password)) {
//                return "redirect:/";
//            }
//        }
//        redirectAttributes.addFlashAttribute("error", "Invalid email or password");
//        return "redirect:/login";
//    }
}