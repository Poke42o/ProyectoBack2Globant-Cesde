package com.example.morro420app.models;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table (name = "booking")
public class Booking {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private LocalDateTime date;

    private Integer time;

    
    public Booking() {
    }


    public Booking(UUID id, LocalDateTime date, Integer time) {
        this.id = id;
        this.date = date;
        this.time = time;
    }


    public UUID getId() {
        return id;
    }


    public void setId(UUID id) {
        this.id = id;
    }


    public LocalDateTime getDate() {
        return date;
    }


    public void setDate(LocalDateTime date) {
        this.date = date;
    }


    public Integer getTime() {
        return time;
    }


    public void setTime(Integer time) {
        this.time = time;
    }

    
}
