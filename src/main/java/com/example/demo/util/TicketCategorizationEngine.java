package com.example.demo.util;

public class TicketCategorizationEngine {

    public static String categorize(String description) {

        if (description == null || description.isEmpty()) {
            return "GENERAL";
        }

        String text = description.toLowerCase();

        if (text.contains("payment") || text.contains("refund")) {
            return "BILLING";
        }

        if (text.contains("login") || text.contains("password")) {
            return "AUTHENTICATION";
        }

        if (text.contains("error") || text.contains("issue")) {
            return "TECHNICAL";
        }

        return "GENERAL";
    }
}
