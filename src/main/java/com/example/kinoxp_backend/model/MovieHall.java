package com.example.kinoxp_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.*;

@Entity
public class MovieHall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @OneToMany(mappedBy = "movieHall", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<MovieSeat> seatList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<MovieSeat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<MovieSeat> seatList) {
        this.seatList = seatList;
    }
}
