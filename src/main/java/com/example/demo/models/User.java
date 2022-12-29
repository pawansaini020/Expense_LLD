package com.example.demo.models;

import lombok.Getter;

@Getter
public class User {
    private String id;
    private String name;
    private String email;
    private String phoneNumber;

    public User(String id, String name, String email, String phoneNumber){
        this.id=id;
        this.name=name;
        this.email=email;
        this.phoneNumber=phoneNumber;
    }
}
