package com.example.morro420app.services;

import java.util.List;
import java.util.UUID;

import com.example.morro420app.dtos.BookingDto;
import com.example.morro420app.dtos.UserDto;
import com.example.morro420app.models.Booking;

public interface IBookingService {

    BookingDto saveUserInBD (Booking data);

    BookingDto modifyUserInBD (Booking data, UUID id);

    List<UserDto> searchUserInBD ();

    void deleteUserInBD (UUID id);

}
