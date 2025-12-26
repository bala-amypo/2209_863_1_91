package com.example.demo.service;

import com.example.demo.model.Ticket;
import java.util.List;

public interface TicketService {
    Ticket create(Ticket ticket);
    Ticket get(Long id);
    List<Ticket> getAll();
    Ticket updateCategory(Long ticketId, String categoryName);
}
