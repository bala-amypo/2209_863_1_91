package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class CategorizationRule(){

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String category;

    @NotBlank
    private String keyword;

    private String matchType;

    private Integer priority;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist(){
        createdAt=LocalDateTime.now();
    }
    
}