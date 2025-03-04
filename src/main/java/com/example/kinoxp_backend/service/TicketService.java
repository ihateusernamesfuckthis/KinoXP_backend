package com.example.kinoxp_backend.service;

import com.example.kinoxp_backend.model.Ticket;
import com.example.kinoxp_backend.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository; // Field injection

    // Get all tickets
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    // Get a single ticket by ID
    public Optional<Ticket> getTicketById(int id) {
        return ticketRepository.findById(id);
    }

    // Add or update a ticket
    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    // Delete a ticket by ID
    public void deleteTicket(int id) {
        ticketRepository.deleteById(id);
    }
}
