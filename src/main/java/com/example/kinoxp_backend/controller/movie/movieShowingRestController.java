package com.example.kinoxp_backend.controller.movie;

import com.example.kinoxp_backend.model.movie.MovieShowing;
import com.example.kinoxp_backend.service.movie.MovieShowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class movieShowingRestController {

    @Autowired
    private MovieShowingService movieShowingService;

    @PostMapping("/movieShowingList")
    public MovieShowing createMovieShowing(@RequestBody MovieShowing showing) {
        return movieShowingService.saveMovieShowing(showing);
    }

    @GetMapping("/movieShowingList")
    public List<MovieShowing> getAllMovieShowings() {
        return movieShowingService.getAllMovieShowings();
    }

    @GetMapping("/movieShowingList/{movieId}")
    public List<MovieShowing> getMovieShowingsByMovieId(@PathVariable int movieId) {
        return movieShowingService.getMovieShowingsByMovieId(movieId);
    }

}
