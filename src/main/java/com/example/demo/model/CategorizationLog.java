package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "categorization_logs")
public class CategorizationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String previousCategory;
    private String newCategory;
    private String status;                 // Example: SUCCESS / FAILED

    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;            

    public CategorizationLog() {
    }

    public CategorizationLog(String previousCategory, String newCategory, String status, LocalDateTime timestamp, Ticket ticket) {
        this.previousCategory = previousCategory;
        this.newCategory = newCategory;
        this.status = status;
        this.timestamp = timestamp;
        this.ticket = ticket;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPreviousCategory() {
        return previousCategory;
    }

    public void setPreviousCategory(String previousCategory) {
        this.previousCategory = previousCategory;
    }

    public String getNewCategory() {
        return newCategory;
    }

    public void setNewCategory(String newCategory) {
        this.newCategory = newCategory;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
