package com.example.demo.entity;

import jakarta.persistence.*;
import java

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

    public String getDescription(){
    return description;
    }

    public void setDecription(String description){
    this.description=description;
    }

    public String getLocation(){
    return location;
    }

    public void setLocation(String location){
    this.location=location;
    }

    public String getCreatedBy(){
        return createdBy;
    }

    public void setCreatedBy(String createdBy){
        this.createdBy=createdBy;
    }

    public Category getAssignedCategory(){
        return assignedCategory;
    }

    public void setAssignedCategory(Category assignedCategory){
        this.assignedCategory=assignedCategory;
    }

    public String getUrgecyLevel(){
        return urgencyLevel;
    }

    public void setUrgencyLevel(String urgencyLevel){
        this.urgencyLevel=urgencyLevel;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public Ticket(){

    }

    public Ticket(String title,String description,String location,String createdBy,Category assignedCategory,String urgencyLevel){
        this.title=title;
        thhis.description=description;
        this.location=location;
        this.createdBy=createdBy;
        this.assignedCategory=assignedCategory;
        this.urgencyLebel=urgencyLevel;
    }

}