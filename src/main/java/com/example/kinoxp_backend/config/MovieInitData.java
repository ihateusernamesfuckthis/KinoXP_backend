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
        movie1.setName("Blaze of Fury");
        movie1.setDuration(120);
        movie1.setGenre("Action");
        movie1.setAgeLimit(16);
        movie1.setDirector("James Blackwood");
        movie1.setDescription("Action-packed movie.");
        movie1.setPictureUrl("/uploads/blaze_of_fury.webp");
        movieRepository.save(movie1);

        Movie movie2 = new Movie();
        movie2.setName("Laugh Riot");
        movie2.setDuration(90);
        movie2.setGenre("Comedy");
        movie2.setAgeLimit(12);
        movie2.setDirector("Sophie Montgomery");
        movie2.setDescription("A hilarious comedy.");
        movie2.setPictureUrl("/uploads/laugh_riot.webp");
        movieRepository.save(movie2);

        Movie movie3= new Movie();
        movie3.setName("The Misfits Comedy");
        movie3.setDuration(90);
        movie3.setGenre("Comedy");
        movie3.setAgeLimit(12);
        movie3.setDirector("James Blackwood");
        movie3.setDescription("A hilarious comedy.");
        movie3.setPictureUrl("/uploads/the_misfit_comedy.webp");
        movieRepository.save(movie3);

        Movie movie4 = new Movie();
        movie4.setName("Mystery in the Dark");
        movie4.setDuration(110);
        movie4.setGenre("Thriller");
        movie4.setAgeLimit(18);
        movie4.setDirector("Harold Pierce");
        movie4.setDescription("A chilling thriller full of suspense.");
        movie4.setPictureUrl("/uploads/mystery_in_the_dark.webp");
        movieRepository.save(movie4);

        Movie movie5 = new Movie();
        movie5.setName("Dreams Unfold");
        movie5.setDuration(150);
        movie5.setGenre("Drama");
        movie5.setAgeLimit(13);
        movie5.setDirector("Emily Turner");
        movie5.setDescription("A dramatic tale of love and sacrifice.");
        movie5.setPictureUrl("/uploads/dreams_unfold.webp");
        movieRepository.save(movie5);

        Movie movie6 = new Movie();
        movie6.setName("Galactic Adventures");
        movie6.setDuration(135);
        movie6.setGenre("Sci-Fi");
        movie6.setAgeLimit(12);
        movie6.setDirector("Lucas Redford");
        movie6.setDescription("A space exploration story with mind-bending twists.");
        movie6.setPictureUrl("/uploads/galactic_adventures.webp");
        movieRepository.save(movie6);

        Movie movie7 = new Movie();
        movie7.setName("The Last Stand");
        movie7.setDuration(105);
        movie7.setGenre("Action");
        movie7.setAgeLimit(16);
        movie7.setDirector("Jessica Clark");
        movie7.setDescription("A soldier fights to save the last city on Earth.");
        movie7.setPictureUrl("/uploads/the_last_stand.webp");
        movieRepository.save(movie7);

        Movie movie8 = new Movie();
        movie8.setName("Falling for You");
        movie8.setDuration(95);
        movie8.setGenre("Romance");
        movie8.setAgeLimit(12);
        movie8.setDirector("Lily Thompson");
        movie8.setDescription("A romantic comedy about unexpected love.");
        movie8.setPictureUrl("/uploads/falling_for_you.webp");
        movieRepository.save(movie8);

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
