package com.example.morro420app.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.morro420app.models.Booking;

@Repository
public interface IBookingRepository extends JpaRepository <Booking, UUID>{


    
}
