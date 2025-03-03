package com.example.kinoxp_backend.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class MovieSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int rowNumber;
    private int seatNumber;

    @ManyToOne
    @JoinColumn(name = "movie_hall_id", nullable = false)
    private MovieHall movieHall;

    @OneToMany(mappedBy = "movieSeat")
    private List<Ticket> tickets;


public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public MovieHall getMovieHall() {
        return movieHall;
    }
    test
    public void setMovieHall(MovieHall movieHall) {
        this.movieHall = movieHall;
    }
}