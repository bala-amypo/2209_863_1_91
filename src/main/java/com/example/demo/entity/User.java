package com.example.demp.entity;


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

}