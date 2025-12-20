package com.example.demo.service;

import com.example.demo.model.Ticket;
import java.util.*;

public interface TicketService{

    Ticket createTicket(Ticket ticket);

    List<Ticket> getAllTickets();

    Ticket getTicketById(Long id);
}