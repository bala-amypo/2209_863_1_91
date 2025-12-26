package com.example.demo.util;

import com.example.demo.model.*;

import java.util.List;

public class TicketCategorizationEngine {

    /**
     * Categorize the given ticket using rules, categories, and urgency policies.
     * Updates ticket.assignedCategory, ticket.urgencyLevel, and logs applied rules.
     */
    public void categorize(
            Ticket ticket,
            List<Category> categories,
            List<CategorizationRule> rules,
            List<UrgencyPolicy> policies,
            List<CategorizationLog> logs
    ) {
        // 1. Default values
        ticket.setAssignedCategory(null);
        ticket.setUrgencyLevel("LOW");

        // 2. Apply rules to find category
        CategorizationRule appliedRule = null;
        int highestPriority = Integer.MIN_VALUE;

        for (CategorizationRule rule : rules) {
            String keyword = rule.getKeyword();
            if (keyword == null) continue;

            String content = (ticket.getTitle() + " " + ticket.getDescription()).toLowerCase();
            boolean matches = false;

            switch (rule.getMatchType()) {
                case "CONTAINS":
                    matches = content.contains(keyword.toLowerCase());
                    break;
                case "EQUALS":
                    matches = content.equalsIgnoreCase(keyword);
                    break;
                case "STARTS_WITH":
                    matches = content.startsWith(keyword.toLowerCase());
                    break;
                case "ENDS_WITH":
                    matches = content.endsWith(keyword.toLowerCase());
                    break;
            }

            if (matches && rule.getPriority() != null && rule.getPriority() > highestPriority) {
                appliedRule = rule;
                highestPriority = rule.getPriority();
            }
        }

        if (appliedRule != null) {
            ticket.setAssignedCategory(appliedRule.getCategory());
            ticket.setUrgencyLevel(appliedRule.getCategory().getDefaultUrgency());
        }

        // 3. Apply urgency policies (override)
        for (UrgencyPolicy policy : policies) {
            String keyword = policy.getKeyword();
            if (keyword != null && (ticket.getTitle() + " " + ticket.getDescription()).toLowerCase()
                    .contains(keyword.toLowerCase())) {
                ticket.setUrgencyLevel(policy.getUrgencyOverride());
            }
        }

        // 4. Add to logs
        if (appliedRule != null) {
            CategorizationLog log = new CategorizationLog();
            log.setTicket(ticket);
            log.setAppliedRule(appliedRule);
            logs.add(log);
        }
    }
}
