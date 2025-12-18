package com.example.demo.java;

import jakarta.persistence.*;

@Entity
public class CategorizationLog{

    @Id
    @GenratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Integer ticket;

    private Integet appliedRule;

    
}