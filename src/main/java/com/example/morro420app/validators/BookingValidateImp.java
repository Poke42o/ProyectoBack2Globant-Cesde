package com.example.morro420app.validators;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.example.morro420app.models.Booking;

@Component
public class BookingValidateImp implements IBookingValidator {

    @Override
    public void validateNewBooking(Booking data) {
        validateDateNotNull(data.getDate());
        validateTimeNotBlank(data.getTime());
        validateFutureDate(data.getDate());
    }

    @Override
    public void validateDataModify(Booking data) {
        validateDateNotNull(data.getDate());
        validateFutureDate(data.getDate());
    }

    private void validateDateNotNull(LocalDateTime date) {
        if (date == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "The booking date cannot be empty."
            );
        }
    }

    private void validateTimeNotBlank(String time) {
        if (time == null || time.isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "The booking time cannot be empty."
            );
        }
    }

    private void validateFutureDate(LocalDateTime date) {
        if (date.isBefore(LocalDateTime.now())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "The booking date must be in the future."
            );
        }
    }
}
