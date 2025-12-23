package com.example.demo.util;

import com.example.demo.model.*;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.regex.Pattern;

@Component
public class TicketCategorizationEngine {

    public CategorizationResult categorize(Ticket ticket, List<Category> categories, List<CategorizationRule> rules, List<UrgencyPolicy> policies) {
        Category matchedCategory = null;
        CategorizationRule matchedRule = null;
        String matchedKeyword = null;
        String urgency = "LOW";

        // Sort rules by priority (higher first)
        rules.sort((r1, r2) -> r2.getPriority().compareTo(r1.getPriority()));

        // Find matching rule
        for (CategorizationRule rule : rules) {
            if (matchesRule(ticket.getDescription(), rule)) {
                matchedCategory = rule.getCategory();
                matchedRule = rule;
                matchedKeyword = rule.getKeyword();
                urgency = matchedCategory.getDefaultUrgency();
                break;
            }
        }

        // Apply urgency policies
        for (UrgencyPolicy policy : policies) {
            if (ticket.getDescription().toLowerCase().contains(policy.getKeyword().toLowerCase())) {
                urgency = policy.getUrgencyOverride();
                break;
            }
        }

        return new CategorizationResult(matchedCategory, matchedRule, matchedKeyword, urgency);
    }

    private boolean matchesRule(String description, CategorizationRule rule) {
        String keyword = rule.getKeyword();
        String matchType = rule.getMatchType();
        
        switch (matchType.toUpperCase()) {
            case "EXACT":
                return description.equals(keyword);
            case "CONTAINS":
                return description.toLowerCase().contains(keyword.toLowerCase());
            case "REGEX":
                return Pattern.compile(keyword, Pattern.CASE_INSENSITIVE).matcher(description).find();
            default:
                return false;
        }
    }

    public static class CategorizationResult {
        private final Category category;
        private final CategorizationRule rule;
        private final String matchedKeyword;
        private final String urgency;

        public CategorizationResult(Category category, CategorizationRule rule, String matchedKeyword, String urgency) {
            this.category = category;
            this.rule = rule;
            this.matchedKeyword = matchedKeyword;
            this.urgency = urgency;
        }

        public Category getCategory() { return category; }
        public CategorizationRule getRule() { return rule; }
        public String getMatchedKeyword() { return matchedKeyword; }
        public String getUrgency() { return urgency; }
    }
}