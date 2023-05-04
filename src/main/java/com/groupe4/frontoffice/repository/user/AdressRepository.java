package com.groupe4.frontoffice.repository.user;

import com.groupe4.frontoffice.model.user.Adress;
import com.groupe4.frontoffice.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressRepository extends JpaRepository<Adress, Integer> {
}
