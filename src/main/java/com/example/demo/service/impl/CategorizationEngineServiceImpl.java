package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.CategorizationEngineService;
import com.example.demo.util.TicketCategorizationEngine;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategorizationEngineServiceImpl implements CategorizationEngineService {
    private final TicketRepository ticketRepository;
    private final CategoryRepository categoryRepository;
    private final CategorizationRuleRepository ruleRepository;
    private final UrgencyPolicyRepository policyRepository;
    private final CategorizationLogRepository logRepository;
    private final TicketCategorizationEngine engine;

    public CategorizationEngineServiceImpl(TicketRepository ticketRepository, CategoryRepository categoryRepository,
                                         CategorizationRuleRepository ruleRepository, UrgencyPolicyRepository policyRepository,
                                         CategorizationLogRepository logRepository, TicketCategorizationEngine engine) {
        this.ticketRepository = ticketRepository;
        this.categoryRepository = categoryRepository;
        this.ruleRepository = ruleRepository;
        this.policyRepository = policyRepository;
        this.logRepository = logRepository;
        this.engine = engine;
    }

    @Override
    public Ticket categorizeTicket(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found"));

        List<Category> categories = categoryRepository.findAll();
        List<CategorizationRule> rules = ruleRepository.findAll();
        List<UrgencyPolicy> policies = policyRepository.findAll();

        TicketCategorizationEngine.CategorizationResult result = engine.categorize(ticket, categories, rules, policies);

        if (result.getCategory() != null) {
            ticket.setAssignedCategory(result.getCategory());
            ticket.setUrgencyLevel(result.getUrgency());
            ticketRepository.save(ticket);

            CategorizationLog log = new CategorizationLog(
                    ticket, result.getRule(), result.getMatchedKeyword(),
                    result.getCategory().getCategoryName(), result.getUrgency()
            );
            logRepository.save(log);
        }

        return ticket;
    }

    @Override
    public List<CategorizationLog> getLogsForTicket(Long ticketId) {
        return logRepository.findByTicketId(ticketId);
    }

    @Override
    public CategorizationLog getLog(Long id) {
        return logRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Log not found"));
    }
}