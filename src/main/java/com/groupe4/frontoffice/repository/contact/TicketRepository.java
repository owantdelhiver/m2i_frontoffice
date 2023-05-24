package com.groupe4.frontoffice.repository.contact;

import com.groupe4.frontoffice.model.contact.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
