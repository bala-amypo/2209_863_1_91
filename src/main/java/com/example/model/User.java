package com.example.demo.model;

import java.io.Serializable;
import java.io.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.*;

import jakarta.persistance.*;

@Entity
@Table(name="user")
public class User{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="fullName",nullable=false)
    private String fullName;

    @Column(name="email",unique=true,nullable=false)
    private String email;

     @Column(name="password",nullable=false)
    private String password;

     @Column(name="role",nullable=false)
    private String role;

     @Column(name="createdAt",unique=true,nullable=false)
    private String createdAt;

}