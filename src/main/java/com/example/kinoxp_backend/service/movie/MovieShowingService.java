package com.example.kinoxp_backend.service.movie;

import com.example.kinoxp_backend.model.movie.MovieShowing;
import com.example.kinoxp_backend.repository.movie.MovieShowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;

@Service
public class MovieShowingService {

    @Autowired
    private MovieShowingRepository movieShowingRepository;

    public MovieShowing saveMovieShowing(MovieShowing showing) {
        return movieShowingRepository.save(showing);
    }

    public List<MovieShowing> getAllMovieShowings() {
        return movieShowingRepository.findAll();
    }


    public List<MovieShowing> getMovieShowingsByDateRange(LocalDate startDate, LocalDate endDate) {
        return movieShowingRepository.findByShowDateBetween(startDate, endDate);
    }

    public List<MovieShowing> getMovieShowingsByMovieId(int movieId) {
        return movieShowingRepository.findByMovieId(movieId);
    }

    public Optional<MovieShowing> findById(int id) {
        return movieShowingRepository.findById(id);
    }

    @Transactional
    public MovieShowing save(MovieShowing movieShowing) {
        return movieShowingRepository.save(movieShowing);
    }

}
