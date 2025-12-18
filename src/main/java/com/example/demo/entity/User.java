package com.example.demp.entity;

import jakarta.persistence.*;

@Entity
public class User{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String fullName;

    @Column(nullable=false,unique=true)
    private String email;

    @Column(nullable=false)
    private String password;

    private String role="USER";

    private  LocalDateTime createdAt;

    @PrePersist
    public void createdAt(){
        createdAt=LocalDateTime.now();
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
    this.id=id;
    }

    public String getfullName(){
    return fullName;
    }

    public void setfullName()

}