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

    @Column()
}