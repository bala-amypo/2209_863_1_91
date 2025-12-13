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

    @Column(nullable=false)
    private String fullName;

    @Column(unique=true,nullable=false)
    private String email;

     @Column(nullable=false)
    private String password;

     @Column(nullable=false)
    private String role;

     @Column(updatable=false)
    private String createdAt ;
    
    @prePersist
    protected void onCreate(){
        this.createdAt=LocalDateTime.now();
        if(this.role==null){
            this.role="USER";
        }
    }

}