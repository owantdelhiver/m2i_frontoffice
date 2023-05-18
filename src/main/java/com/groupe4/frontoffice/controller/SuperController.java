package com.groupe4.frontoffice.controller;

import com.groupe4.frontoffice.model.user.User;
import com.groupe4.frontoffice.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class SuperController {
    @Autowired
    UserService userService;

    public User getUserSession(HttpSession httpSession) {
        return userService.findByEmail((String) httpSession.getAttribute("email"));
    }
}
