package com.example.kinoxp_backend.model;

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

}