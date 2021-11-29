package com.yaksun.spring_carrent.service;

import com.yaksun.spring_carrent.model.entity.RentForm;
import com.yaksun.spring_carrent.model.entity.Ticket;
import com.yaksun.spring_carrent.model.enums.Status;

import java.util.List;

public interface TicketService {
    void save(Ticket ticket, RentForm form);

    List<Ticket> findTicketsByUsername(String Username);

    void changeTicketStatus(Long id, Status status);
}
