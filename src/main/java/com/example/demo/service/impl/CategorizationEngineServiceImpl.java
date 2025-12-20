package com.example.demo.service.impl;

import com.example.demo.model.Ticket;
import com.example.demo.model.CategorizationLog;
import com.example.demo.repository.TicketRepository;
import com.example.demo.repository.CategorizationLogRepository;
import com.examle.dem0.service.CategorizationEngineService;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CategorizationEngineServiceImpl implements CategorizationEngineService{

    private final TicketRepository ticketRepository;
    private final CategorizationLogRepository logRepository
}