package com.groupe4.frontoffice.repository.user;

import com.groupe4.frontoffice.model.user.Role;
import com.groupe4.frontoffice.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findById(int id);
    Optional<Role> findByName(String name);
}
