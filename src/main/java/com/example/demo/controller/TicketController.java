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
    public T
}