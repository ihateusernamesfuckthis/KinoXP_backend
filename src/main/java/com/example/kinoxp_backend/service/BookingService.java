package com.example.kinoxp_backend.service;

import com.example.kinoxp_backend.model.Booking;
import com.example.kinoxp_backend.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository; // Field injection

    // Get all bookings
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Get a single booking by ID
    public Optional<Booking> getBookingById(int id) {
        return bookingRepository.findById(id);
    }

    // Add or update a booking
    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    // Delete a booking by ID
    public void deleteBooking(int id) {
        bookingRepository.deleteById(id);
    }
}
