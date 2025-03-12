package com.example.kinoxp_backend.config;

import com.example.kinoxp_backend.model.movie.*;
import com.example.kinoxp_backend.repository.movie.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class MovieInitData implements CommandLineRunner {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieShowingRepository movieShowingRepository;
    @Autowired
    private MovieSeatRepository movieSeatRepository;
    @Autowired
    private MovieHallRepository movieHallRepository;

    @Override
    public void run(String... args) throws Exception {
        MovieHall hall1 = new MovieHall();
        movieHallRepository.save(hall1);

        MovieHall hall2 = new MovieHall();
        movieHallRepository.save(hall2);


        Movie movie1 = new Movie();
        movie1.setName("Movie 1");
        movie1.setDuration(120);
        movie1.setGenre("Action");
        movie1.setAgeLimit(16);
        movie1.setDirector("Director 1");
        movie1.setDescription("Action-packed movie.");
        movie1.setPictureUrl("URL1");
        movieRepository.save(movie1);

        Movie movie2 = new Movie();
        movie2.setName("Movie 2");
        movie2.setDuration(90);
        movie2.setGenre("Comedy");
        movie2.setAgeLimit(12);
        movie2.setDirector("Director 2");
        movie2.setDescription("A hilarious comedy.");
        movie2.setPictureUrl("URL2");
        movieRepository.save(movie2);

        MovieShowing showing1 = new MovieShowing();
        showing1.setMovie(movie1);
        showing1.setStartTime(LocalTime.of(14, 30));
        showing1.setShowDate(LocalDate.of(2025, 3, 11));
        showing1.setMovieHall(hall1);
        movieShowingRepository.save(showing1);

        MovieShowing showing2 = new MovieShowing();
        showing2.setMovie(movie1);
        showing2.setStartTime(LocalTime.of(17, 30));
        showing2.setShowDate(LocalDate.of(2025, 3, 12));
        showing2.setMovieHall(hall1);
        movieShowingRepository.save(showing2);

        MovieShowing showing3 = new MovieShowing();
        showing3.setMovie(movie2);
        showing3.setStartTime(LocalTime.of(16, 30));
        showing3.setShowDate(LocalDate.of(2025, 3, 5));
        showing3.setMovieHall(hall2);
        movieShowingRepository.save(showing3);

        MovieShowing showing4 = new MovieShowing();
        showing4.setMovie(movie2);
        showing4.setStartTime(LocalTime.of(19, 00));
        showing4.setShowDate(LocalDate.of(2025, 3, 7));
        showing4.setMovieHall(hall2);
        movieShowingRepository.save(showing4);

    }
}
