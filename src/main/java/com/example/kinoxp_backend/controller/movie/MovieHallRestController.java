package com.example.kinoxp_backend.controller.movie;

import com.example.kinoxp_backend.model.movie.MovieHall;
import com.example.kinoxp_backend.service.movie.MovieHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/movie-hall")
public class MovieHallRestController {

    @Autowired
    MovieHallService movieHallService;

    @GetMapping
    public List<MovieHall> getAllMovieHalls() {
        return movieHallService.getAllMovieHalls();
    }
}
