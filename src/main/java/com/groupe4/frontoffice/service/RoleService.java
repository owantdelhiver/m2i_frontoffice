package com.groupe4.frontoffice.service;

import com.groupe4.frontoffice.model.user.Role;
import com.groupe4.frontoffice.repository.user.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public Role getByName(String name) {
        return roleRepository.findByName(name).get();
    }
}
