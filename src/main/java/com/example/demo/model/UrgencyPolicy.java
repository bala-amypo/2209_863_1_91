package com.example.demo.model;

import jakarta.persistece.*;
import java.time.LocalDateTime;

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

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public String PolicyName
    
}