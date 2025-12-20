package com.example.demo.service.impl;

import com.example.demo.model.Ticket;
import com.example.demo.repository.TicketRepository;
import com.example.demo.service.TicketService;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TicketServiceImpl implements TicketService{
    private final TicketRepository ticketRepository;
    public TicketServiceImpl(TicketRepository ticketRepository){
        this.ticketRepository
    }