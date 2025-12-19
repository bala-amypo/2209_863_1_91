package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class CategorizationRule(){

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private  Category category;

    @NotBlank
    private String keyword;

    private String matchType;

    private Integer priority;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist(){
        createdAt=LocalDateTime.now();
    }

    public Long getId(){
        return id;
    }

    public Long setId(Long id){
        this.id=id;
    }

    public Category getCategory(){
        return category;
    }

    public void setCategory(Category category){
        this.category=category;
    }

    public String getKeyword(){
        return keyword;
    }

    public void setKeyword(String keyword){
        this.keyword=keyword;
    }

    public String getMatchType(){
        return matchType;
    }

    public void setMatchType(String matchType){
        this.matchType=matchType;
    }

    public Integer getPriority(){
        return priority;
    }

    public void setPriority(Integer priority){
        this.priority=priority;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public CategorizationRule(){
        
    }

    
}