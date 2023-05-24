package com.groupe4.frontoffice.service;

import com.groupe4.frontoffice.model.contact.Ticket;
import com.groupe4.frontoffice.repository.contact.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    public Ticket save(Ticket ticket){

        return ticketRepository.save(ticket);
    }

}
