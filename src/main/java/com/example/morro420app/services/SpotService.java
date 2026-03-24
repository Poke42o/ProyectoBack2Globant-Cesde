package com.example.morro420app.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.morro420app.models.Booking;
import com.example.morro420app.models.Spot;
import com.example.morro420app.repositories.IBookingRepository;
import com.example.morro420app.repositories.ISpotRepository;

@Service
public class SpotService {

    @Autowired
    private ISpotRepository spotRepository;

    public boolean saveSpotBD (Spot data){
        return false;
    }

    public boolean modifySpotBD (Spot data, UUID id){
        return false;
    }

    public boolean deleteSpotDB (UUID id){
        return false;
    }

    public boolean searchSpotBD (){
        return false;
    }
    
}
