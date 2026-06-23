package com.example.morro420app.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.morro420app.models.Booking;
import com.example.morro420app.repositories.IBookingRepository;
import com.example.morro420app.validators.IBookingValidator;

@Service
public class BookingServiceImp implements IBookingService {

    private final IBookingRepository bookingRepository;
    private final IBookingValidator bookingValidator;

    public BookingServiceImp(IBookingRepository bookingRepository, IBookingValidator bookingValidator) {
        this.bookingRepository = bookingRepository;
        this.bookingValidator = bookingValidator;
    }

    @Override
    public Booking saveBookingBD(Booking data) {
        this.bookingValidator.validateNewBooking(data);
        return this.bookingRepository.save(data);
    }

    @Override
    public Booking modifyBookingBD(Booking data, UUID id) {
        Optional<Booking> bookingToSearch = this.bookingRepository.findById(id);
        if (bookingToSearch.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Booking not found");
        }

        Booking bookingFound = bookingToSearch.get();
        this.bookingValidator.validateDataModify(data);
        bookingFound.setDate(data.getDate());
        bookingFound.setTime(data.getTime());
        return this.bookingRepository.save(bookingFound);
    }

    @Override
    public boolean deleteBookingDB(UUID id) {
        if (!this.bookingRepository.existsById(id)) {
            return false;
        }
        this.bookingRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Booking> searchBookingBD() {
        return this.bookingRepository.findAll();
    }
}
