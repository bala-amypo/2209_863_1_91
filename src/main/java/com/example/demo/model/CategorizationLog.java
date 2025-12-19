package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CategorizationLog{

    @Id
    @GenratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private  Ticket ticket;

    @ManyToOne
    private  CategorizationRule appliedRule;

    private String matchedKeyword;

    private String assignedCategory;

    private String assignedUrgency;

    private LocalDateTime loggedAt;

    @PrePerist
    public void prePersist(){
        loggedAt=LocalDateTime.now();
    }

    public Long getId(){
        return id;
    }

    public CategorizationRule getAppliedRule(){
        return appliedRule;
    }

    public void setAppliedRule(CategorizationRule appliedRule){
        this.appliedRule=appliedRule;
    }

    public Ticket getTicket(){
        return ticket;
    }

    public void setTicket(Ticket ticket){
        this.ticket=ticket;
    }

    public String getMatchedKeyword(){
        return matchedKeyword;
    }

    public void setMatchedKeyword(String matchedKeyword){
        this.matchedKeyword=matchedKeyword;
    }

    public String getAssignedCategory(){
        return assignedCategory;
    }

    public void setAssignedCategory(String assignedCategory){
        this.assignedCategory=assignedCategory;
    }

    public String getAssignedUrgency(){
        return assignedUrgency;
    }

    public void setAssignedUrgency(String assignedUrgency){
        this.assignedUrgency=assignedUrgency;
    }

    public LocalDateTime getLoggedAt(){
        return loggedAt;
    }

    public CategorizationLog(){

    }

    public CategrizationLog(Ticket ticket,CategorizationRule appliedRule,String matchedKeyword,String assignedCategory,String assignedUrgency){
       this.ticket=ticket;
       this.appliedRule=appliedRule;
       this.matchedKeyword=matchedKeyword;
       this.assignedCategory=assignedCategory;
       this.assignedUrgency=assignedUrgency;
    }
    
}