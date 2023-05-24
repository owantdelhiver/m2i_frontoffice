package com.groupe4.frontoffice.repository.contact;

import com.groupe4.frontoffice.model.contact.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
