package com.groupe4.frontoffice.service;
import com.groupe4.frontoffice.model.user.Adress;
import com.groupe4.frontoffice.repository.user.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdressService {
    @Autowired
    AdressRepository adressRepository;

    public List<Adress> fetchAll() {
        return adressRepository.findAll();
    }

    public void save(Adress adress) {
        adressRepository.save(adress);
    }

    public int findById(int id) {
        adressRepository.findById(id);
        return new Adress().getId();
    }

}
