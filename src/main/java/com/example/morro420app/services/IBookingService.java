package com.example.morro420app.services;

import java.util.List;
import java.util.UUID;

import com.example.morro420app.models.Booking;

public interface IBookingService {

    Booking saveBookingBD(Booking data);

    Booking modifyBookingBD(Booking data, UUID id);

    List<Booking> searchBookingBD();

    boolean deleteBookingDB(UUID id);

}
