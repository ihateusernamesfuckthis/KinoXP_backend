package com.example.kinoxp_backend.model;

import jakarta.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "booking_id",nullable = false)
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "movie_showing_id", nullable = false)
    private MovieShowing movieShowing;

    @ManyToOne
    @JoinColumn(name = "movie_seat_id", nullable = false)
    private MovieSeat movieSeat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public MovieShowing getMovieShowing() {
        return movieShowing;
    }

    public void setMovieShowing(MovieShowing movieShowing) {
        this.movieShowing = movieShowing;
    }

    public MovieSeat getMovieSeat() {
        return movieSeat;
    }

    public void setMovieSeat(MovieSeat movieSeat) {
        this.movieSeat = movieSeat;
    }
}
