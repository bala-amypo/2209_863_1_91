package com.example.demo.controller;

import com.example.demo.model.CategorizationLog;
import com.example.demo.service.CategorizationLogService;
import org.springframework.we.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/categorize")
public class CategorizationEngineController{

    private final CategorizationLogService CategorizationLogService;
    public CategorizationEngineController(CategorizationLogService categorizationLogService){
        this.categorizationLogService=categorizationLogService;
    }

    @PostMapping("/run/{ticketId}")
    public CategorizationLog categorizeTicket(@PathVariable Long ticketId,@RequestBody CategorizationLog categorizationLog){
        return categorizationLogService.categorizeTicket(ticketId,categorizationLog);
    }

    @GetMapping("/logs/{})
}