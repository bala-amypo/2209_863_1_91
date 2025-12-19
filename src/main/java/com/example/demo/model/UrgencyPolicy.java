package com.example.demo.entity;

import jakarta.persistece,*;

@Entity
public class UrgencyPolicy{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String policyName;

    @Column(nullable=false)
    private String keyword;

    @Column(nullable=false)
    private String urgencyOverride;

    private LocalDateTime createdAt;

`   @PrePersist
    public void prePersist(){
        createdAt=LocalDateTime.now();
    }
    
}