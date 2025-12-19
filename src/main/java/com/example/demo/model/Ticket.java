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

    @ManyToOne
    private Category assignedCategory;

    private String urgencyLevel;

    public Long getId(){
    return id;
    }

    public void setId(Long id){
    this.id=id;
    }

    public String getTitle(){
    return title;
    }

    public void setTitle(String title){
    this.title=title;
    }

    public 

}