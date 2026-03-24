package com.example.morro420app.models;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table (name = "user")
public class User {
    

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String names;

    private String email;

    private String password;
    
    private String rol;


    public User() {
    }


    public User(UUID id, String names, String email, String password, String rol) {
        this.id = id;
        this.names = names;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }


    public UUID getId() {
        return id;
    }


    public void setId(UUID id) {
        this.id = id;
    }


    public String getNames() {
        return names;
    }


    public void setNames(String names) {
        this.names = names;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getRol() {
        return rol;
    }


    public void setRol(String rol) {
        this.rol = rol;
    }


    
}
