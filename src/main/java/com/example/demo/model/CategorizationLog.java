package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CategorizationLog{

    @Id
    @GenratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private  Ticket ticket;

    @ManyToOne
    private  CategorizationRule appliedRule;

    private String matchedKeyword;

    private String assignedCategory;

    private String assignedUrgency;

    private LocalDateTime loggedAt;

    @PrePerist
    public void prePersist(){
        loggedAt=LocalDateTime.now();
    }

    public Long getId(){
        return id;
    }

    public 
    
}