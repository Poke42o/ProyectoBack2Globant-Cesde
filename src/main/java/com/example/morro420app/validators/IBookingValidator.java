package com.example.morro420app.validators;

import com.example.morro420app.models.Booking;

public interface IBookingValidator {

    void validateNewBooking(Booking data);

    void validateDataModify(Booking data);
}
