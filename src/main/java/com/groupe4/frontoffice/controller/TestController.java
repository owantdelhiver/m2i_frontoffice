package com.groupe4.frontoffice.controller;

import com.groupe4.frontoffice.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/auth/test")
    public String test() {
//        User newUser = new User("tata", "tata", passwordEncoder.encode("tata@tata.fr"), "tata", new Cart());
//        userRepository.save(newUser);
        return "test";
    }
}
