package com.example.demo.controller;

import com.example.demo.model.Ticket;
import com.example.demo.service.TicketService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/tickets")
public class TicketController{

    private final TicketService ticketServive;
    public TicketController(TicketService ticketService){
    this.ticketService=ticketService;
    }

    @PostMapping("/createTicket")
    public Ticket createTicket(@RequestBody Ticket ticket){
        return ticketService.createTicket(ticket);
    }

    @GetMapping("/getAllTickets")
    public List<Ticket>getAllTickets(){
        return ticketService.getAllTickets();
    }

    @GetMapping("/get/{id}")
    public Ticket getById()
}