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
    private final CategorizationLogRepository logRepository;
    public CategorizationEngineServiceImpl(TicketRepository ticketRepository,CategorizationLogRepository logRepository){
        this.ticketRepository=ticketRepository;
        this.logRepository=logRepository;
    }

    @Override
    public Ticket categorizeTicket(Long ticketId){
        Ticket ticket=ticketRepository.findById(ticketId).orElseThrow(()->new RuntimeException("Ticket not found"));
        CategorizationLog log=new CategorizationLog();
        log.setTicket(ticket);
        log.setResult("Ticket categorized successfully");
        logRepository.save(log);
    }

    @Override
    public List<CategorizationLog>getLogsForTicket(Long ticketId){
        return logRepository.fi
    }
}