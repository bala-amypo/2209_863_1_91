package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Ticket{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String title;

    @Column
    @Size(min=10)
    private String description;

    private String location;

    private String createdBy;

    private LocalDatTime createdAt;

    @PrePersist
    public void prePersist(){
        createdAt=LocalDateTime.now();
    }

    private String assignedCategory;

    private String urgencyLevel;

}