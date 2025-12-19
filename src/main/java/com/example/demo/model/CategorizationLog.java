package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CategorizationLog{

    @Id
    @GenratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Integer ticket;

    private Integer appliedRule;

    private String matchedKeyword;

    private String assignedCategory;

    private String assignedUrgency;

    private LocalDateTime loggedAt;

    @PrePerist
    public void prePersist(){
        loggedAt=LocalDateTime.now();
    }
    
}