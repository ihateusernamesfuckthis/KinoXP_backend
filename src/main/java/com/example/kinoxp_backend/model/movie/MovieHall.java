package com.example.kinoxp_backend.model.movie;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class MovieHall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @OneToMany(mappedBy = "movieHall", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<MovieShowing> showings = new ArrayList<>();

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<MovieShowing> getShowings() {
        return showings;
    }

    public void setShowings(List<MovieShowing> showings) {
        this.showings = showings;
    }
}
