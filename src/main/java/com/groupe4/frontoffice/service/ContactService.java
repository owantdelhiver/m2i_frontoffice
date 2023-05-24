package com.groupe4.frontoffice.service;

import com.groupe4.frontoffice.model.contact.Contact;
import com.groupe4.frontoffice.repository.contact.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    public Contact saveContact(Contact contact){

        return contactRepository.save(contact);
    }

}
