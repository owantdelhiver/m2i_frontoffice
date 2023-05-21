package com.groupe4.frontoffice.service;

import com.groupe4.frontoffice.model.user.User;
import com.groupe4.frontoffice.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> fetchAll(){
        return userRepository.findAll();
    }

    public void save(User user){userRepository.save(user);}
}