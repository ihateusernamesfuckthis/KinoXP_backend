package com.example.kinoxp_backend.dto.movie;

import java.time.LocalDate;
import java.time.LocalTime;

public class MovieShowingDTO {
    private int movieId;
    private int movieHallId;
    private LocalDate showDate;
    private LocalTime startTime;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getMovieHallId() {
        return movieHallId;
    }

    public void setMovieHallId(int movieHallId) {
        this.movieHallId = movieHallId;
    }

    public LocalDate getShowDate() {
        return showDate;
    }

    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
}
