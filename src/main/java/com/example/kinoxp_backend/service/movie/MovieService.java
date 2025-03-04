package com.example.kinoxp_backend.service.movie;

import com.example.kinoxp_backend.model.movie.Movie;
import com.example.kinoxp_backend.repository.movie.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository; // Field injection

    // Get all movies
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // Get a single movie by ID
    public Optional<Movie> getMovieById(int id) {
        return movieRepository.findById(id);
    }

    // Add or update a movie
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // Delete a movie by ID
    public void deleteMovie(int id) {
        movieRepository.deleteById(id);
    }
}
