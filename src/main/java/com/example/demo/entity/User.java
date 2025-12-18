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

}