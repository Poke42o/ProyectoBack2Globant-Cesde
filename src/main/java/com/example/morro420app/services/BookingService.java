package com.example.morro420app.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.morro420app.models.Booking;
import com.example.morro420app.repositories.IBookingRepository;

@Service
public class BookingService {

   @Autowired
    private IBookingRepository bookingRepository;

    public Booking saveBookingBD (Booking data){
        if (data.getDate() == null || data.getTime() == null) {
            throw new ResponseStatusException(
                HttpStatus.CONFLICT,
                "Date cannot be empty"
            );
            
        }

        if (data.getDate().isBefore(LocalDateTime.now())) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                ""
            );}
            return this.bookingRepository.save(data);

    }

    public boolean modifyBookingBD (Booking data, UUID id){
        return false;
    }

    public boolean deleteBookingDB (UUID id){
        if (!this.bookingRepository.existsById(id)) {
            return false;
            
        }
        this.bookingRepository.deleteById(id);
        return true;
    }

    public List<Booking> searchBookingBD (){
        List<Booking> bookinFound = this.bookingRepository.findAll();
        return bookinFound;
        
    }
}
