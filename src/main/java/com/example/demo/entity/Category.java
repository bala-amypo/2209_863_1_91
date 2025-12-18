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

    @Column(nullable=false)
    private String 
}