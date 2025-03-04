package com.example.kinoxp_backend.config;

import com.example.kinoxp_backend.model.*;
import com.example.kinoxp_backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
    private TicketRepository ticketRepository;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private MovieHallRepository movieHallRepository;

    @Override
    public void run(String... args) throws Exception {
        // Create movie halls
        MovieHall hall1 = new MovieHall();
        movieHallRepository.save(hall1);

        MovieHall hall2 = new MovieHall();
        movieHallRepository.save(hall2);

        // Create movie seats
        MovieSeat seat1 = new MovieSeat();
        seat1.setMovieHall(hall1);
        seat1.setRowsNumber(1);
        seat1.setSeatNumber(1);
        movieSeatRepository.save(seat1);

        MovieSeat seat2 = new MovieSeat();
        seat2.setMovieHall(hall1);
        seat2.setRowsNumber(1);
        seat2.setSeatNumber(2);
        movieSeatRepository.save(seat2);

        // Create movies
        Movie movie1 = new Movie();
        movie1.setName("Movie 1");
        movie1.setDuration(120);
        movie1.setGenre("Action");
        movie1.setAgeLimit(16);
        movie1.setDirector("Director 1");
        movie1.setDescription("Description 1");
        movie1.setPictureUrl("URL1");
        movieRepository.save(movie1);

        Movie movie2 = new Movie();
        movie2.setName("Movie 2");
        movie2.setDuration(90);
        movie2.setGenre("Comedy");
        movie2.setAgeLimit(12);
        movie2.setDirector("Director 2");
        movie2.setDescription("Description 2");
        movie2.setPictureUrl("URL2");
        movieRepository.save(movie2);

        // Create movie showings
        MovieShowing showing1 = new MovieShowing();
        showing1.setMovie(movie1);
        showing1.setShowTime(LocalTime.of(14, 30));
        movieShowingRepository.save(showing1);

        MovieShowing showing2 = new MovieShowing();
        showing2.setMovie(movie2);
        showing2.setShowTime(LocalTime.of(16, 30));
        movieShowingRepository.save(showing2);

        // Create a booking
        Booking booking = new Booking();
        booking.setCustomerName("John Doe");
        bookingRepository.save(booking);

        // Create tickets
        Ticket ticket1 = new Ticket();
        ticket1.setBooking(booking);
        ticket1.setMovieShowing(showing1);
        ticket1.setMovieSeat(seat1);
        ticketRepository.save(ticket1);

        Ticket ticket2 = new Ticket();
        ticket2.setBooking(booking);
        ticket2.setMovieShowing(showing2);
        ticket2.setMovieSeat(seat2);
        ticketRepository.save(ticket2);
    }
}
