package com.example.kinoxp_backend.service;

import com.example.kinoxp_backend.model.MovieSeat;
import com.example.kinoxp_backend.repository.MovieSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieSeatService {

    @Autowired
    private MovieSeatRepository movieSeatRepository; // Field injection

    // Get all movie seats
    public List<MovieSeat> getAllSeats() {
        return movieSeatRepository.findAll();
    }

    // Add or update a seat
    public MovieSeat saveSeat(MovieSeat movieSeat) {
        return movieSeatRepository.save(movieSeat);
    }

    // Delete a seat by ID
    public void deleteSeat(int id) {
        movieSeatRepository.deleteById(id);
    }
}
