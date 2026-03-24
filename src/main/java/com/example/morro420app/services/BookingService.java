package com.example.morro420app.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.morro420app.models.Booking;
import com.example.morro420app.repositories.IBookingRepository;

@Service
public class BookingService {

   @Autowired
    private IBookingRepository bookingRepository;

    public boolean saveBookingBD (Booking data){
        return false;
    }

    public boolean modifyBookingBD (Booking data, UUID id){
        return false;
    }

    public boolean deleteBookingDB (UUID id){
        return false;
    }

    public boolean searchBookingBD (){
        return false;
    }
}
