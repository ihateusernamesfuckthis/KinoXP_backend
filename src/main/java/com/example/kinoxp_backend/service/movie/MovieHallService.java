package com.example.kinoxp_backend.service.movie;

import com.example.kinoxp_backend.model.movie.MovieHall;
import com.example.kinoxp_backend.repository.movie.MovieHallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieHallService {

    @Autowired
    private MovieHallRepository movieHallRepository; // Field injection

    // Get all movie halls
    public List<MovieHall> getAllMovieHalls() {
        return movieHallRepository.findAll();
    }

    // Get a single movie hall by ID
    public Optional<MovieHall> getMovieHallById(int id) {
        return movieHallRepository.findById(id);
    }

    // Add or update a movie hall
    public MovieHall saveMovieHall(MovieHall movieHall) {
        return movieHallRepository.save(movieHall);
    }

    // Delete a movie hall by ID
    public void deleteMovieHall(int id) {
        movieHallRepository.deleteById(id);
    }
}
