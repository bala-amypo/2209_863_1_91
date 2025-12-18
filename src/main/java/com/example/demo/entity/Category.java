package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="categories")
public class Category{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String categoryName;

    private String description;

    @Column(nullable=false)
    private String defaultUrgency;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist(){
        createdAt=LocalDateTime.now();
    }
    
}