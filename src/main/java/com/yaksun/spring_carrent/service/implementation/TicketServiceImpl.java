package com.yaksun.spring_carrent.service.implementation;

import com.yaksun.spring_carrent.model.entity.RentForm;
import com.yaksun.spring_carrent.model.entity.Ticket;
import com.yaksun.spring_carrent.model.enums.Status;
import com.yaksun.spring_carrent.repository.TicketRepository;
import com.yaksun.spring_carrent.service.TicketService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public void save(Ticket ticket, RentForm form) {
        ticket.setUsername(form.getUsername());
        ticket.setPrice(Long.valueOf(form.getPrice()));
        ticket.setStatus(Status.UNPAYED);
        ticket.setCarid(form.getCarid());
        ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> findTicketsByUsername(String Username) {
        List<Ticket> tickets = new ArrayList<>();
        List<Ticket> alltickets = ticketRepository.findAll();
        for (Ticket allticket : alltickets) {
            if (allticket.getUsername().equals(Username)) {
                tickets.add(allticket);
            }
        }
        return tickets;
    }

    @Override
    public void changeTicketStatus(Long id, Status status) {
        ticketRepository.changeTicket(id, status);
    }
}