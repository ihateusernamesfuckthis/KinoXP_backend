package com.example.kinoxp_backend.model.movie;

import com.example.kinoxp_backend.model.movie.MovieHall;
import com.example.kinoxp_backend.model.movie.Ticket;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class MovieSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int rowsNumber;
    private int seatNumber;

    @ManyToOne
    @JoinColumn(name = "movie_hall_id", nullable = false)
    private MovieHall movieHall;

    @OneToMany(mappedBy = "movieSeat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> tickets;


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

    public MovieHall getMovieHall() {
        return movieHall;
    }

    public void setMovieHall(MovieHall movieHall) {
        this.movieHall = movieHall;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}