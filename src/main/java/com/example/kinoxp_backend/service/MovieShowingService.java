package com.example.kinoxp_backend.service;

import com.example.kinoxp_backend.model.MovieShowing;
import com.example.kinoxp_backend.repository.MovieShowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieShowingService {

    @Autowired
    private MovieShowingRepository movieShowingRepository; // Field injection

    // Get all movie showings
    public List<MovieShowing> getAllMovieShowings() {
        return movieShowingRepository.findAll();
    }

    // Get a single movie showing by ID
    public Optional<MovieShowing> getMovieShowingById(int id) {
        return movieShowingRepository.findById(id);
    }

    // Add or update a movie showing
    public MovieShowing saveMovieShowing(MovieShowing movieShowing) {
        return movieShowingRepository.save(movieShowing);
    }

    // Delete a movie showing by ID
    public void deleteMovieShowing(int id) {
        movieShowingRepository.deleteById(id);
    }
}
