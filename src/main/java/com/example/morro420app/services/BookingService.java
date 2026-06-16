package com.example.morro420app.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
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

    public Booking modifyBookingBD (Booking data, UUID id){
        //1. buscar si el usuario existe en BD
        Optional<Booking> booking_to_search = this.bookingRepository.findById(id);
        if (booking_to_search.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "The booking dont exist"
            );
        }
        Booking user_found = booking_to_search.get();

        //2. validar informacion nueva que llega
        if(data.getDate().isBefore(LocalDateTime.now())){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "review the name"
            );
        }

        //3. ejecutar el nuevo guardado y retornar
        user_found.setDate(data.getDate());
        
        return this.bookingRepository.save(user_found);
        
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
