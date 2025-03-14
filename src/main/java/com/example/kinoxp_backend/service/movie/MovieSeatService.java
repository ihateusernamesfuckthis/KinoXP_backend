package com.example.kinoxp_backend.service.movie;

import com.example.kinoxp_backend.model.movie.MovieSeat;
import com.example.kinoxp_backend.repository.movie.MovieSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieSeatService {

    @Autowired
    private MovieSeatRepository movieSeatRepository;

    public void saveSeat(MovieSeat seat) {
        movieSeatRepository.save(seat);
    }


    public List<MovieSeat> findByMovieShowingId(int showingId) {
        return movieSeatRepository.findByMovieShowingId(showingId);
    }
}
