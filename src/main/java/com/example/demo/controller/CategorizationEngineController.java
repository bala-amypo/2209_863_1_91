package com.example.demo.controller;

import com.example.demo.model.CategorizationLog;
import com.example.demo.model.Ticket;
import com.example.demo.service.CategorizationEngineService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/categorize")
public class CategorizationEngineController{

    private final CategorizationEngineService categorizationEngineService;
    public CategorizationEngineController(CategorizationEngineService categorizationEngineService){
        this.categorizationEngineService=categorizationEngineService;
    }

    @PostMapping("/run/{ticketId}")
    public Ticket categorizeTicket(@PathVariable Long ticketId){
        return categorizationEngineService.categorizeTicket(ticketId);
    }

    @GetMapping("/logs/{ticketId}")
    public List<CategorizationLog> getLogsForTicket(@PathVariable Long ticketId){
        return categorizationEngineService.getLogsForTicket(ticketId);
    }

    @GetMapping("/log/{id}")
    public CategorizationLog getLog(@PathVariable Long id){
        return categorizationEngineService.getLog(id );
    }
}