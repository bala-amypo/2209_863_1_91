package com.example.demo.util;

import com.example.demo.model.*;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Comparator;

@Component
public class TicketCategorizationEngine {
    
    // Method signature matches the test cases - takes 4 parameters, returns logs via parameter
    public void categorize(
            Ticket ticket, 
            List<Category> categories,
            List<CategorizationRule> rules, 
            List<UrgencyPolicy> policies,
            List<CategorizationLog> logs) {
        
        String title = ticket.getTitle() != null ? ticket.getTitle().toLowerCase() : "";
        String description = ticket.getDescription() != null ? ticket.getDescription().toLowerCase() : "";
        String fullText = title + " " + description;
        
        // Apply categorization rules
        CategorizationRule matchedRule = rules.stream()
            .filter(rule -> matches(fullText, rule))
            .max(Comparator.comparing(CategorizationRule::getPriority))
            .orElse(null);
        
        if (matchedRule != null) {
            Category category = matchedRule.getCategory();
            ticket.setAssignedCategory(category);
            ticket.setUrgencyLevel(category.getDefaultUrgency());
            
            // Log the categorization
            CategorizationLog log = new CategorizationLog();
            log.setTicket(ticket);
            log.setAppliedRule(matchedRule);
            log.setAction("CATEGORIZED to " + category.getCategoryName());
            log.setTimestamp(LocalDateTime.now());
            logs.add(log);
        }
        
        // Apply urgency policy overrides
        UrgencyPolicy matchedPolicy = policies.stream()
            .filter(policy -> fullText.contains(policy.getKeyword().toLowerCase()))
            .findFirst()
            .orElse(null);
        
        if (matchedPolicy != null) {
            ticket.setUrgencyLevel(matchedPolicy.getUrgencyOverride());
            
            // Log the urgency override
            CategorizationLog log = new CategorizationLog();
            log.setTicket(ticket);
            log.setAction("URGENCY_OVERRIDE to " + matchedPolicy.getUrgencyOverride());
            log.setTimestamp(LocalDateTime.now());
            logs.add(log);
        }
        
        // Set default urgency if none assigned
        if (ticket.getUrgencyLevel() == null) {
            ticket.setUrgencyLevel("LOW");
        }
    }
    
    private boolean matches(String text, CategorizationRule rule) {
        String keyword = rule.getKeyword().toLowerCase();
        String matchType = rule.getMatchType();
        
        if ("CONTAINS".equalsIgnoreCase(matchType)) {
            return text.contains(keyword);
        } else if ("EXACT".equalsIgnoreCase(matchType)) {
            return text.equals(keyword);
        } else if ("STARTS_WITH".equalsIgnoreCase(matchType)) {
            return text.startsWith(keyword);
        } else if ("ENDS_WITH".equalsIgnoreCase(matchType)) {
            return text.endsWith(keyword);
        }
        
        return text.contains(keyword); // default to contains
    }
}