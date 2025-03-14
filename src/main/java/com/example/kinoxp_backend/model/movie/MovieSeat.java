package com.example.kinoxp_backend.model.movie;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class MovieSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int rowsNumber;
    private int seatNumber;
    private boolean isBooked;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "movie_showing_id", nullable = false)
    private MovieShowing movieShowing;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRowsNumber() {
        return rowsNumber;
    }

    public void setRowsNumber(int rowsNumber) {
        this.rowsNumber = rowsNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setIsBooked(boolean booked) {
        isBooked = booked;
    }

    public MovieShowing getMovieShowing() {
        return movieShowing;
    }

    public void setMovieShowing(MovieShowing movieShowing) {
        this.movieShowing = movieShowing;
    }

}