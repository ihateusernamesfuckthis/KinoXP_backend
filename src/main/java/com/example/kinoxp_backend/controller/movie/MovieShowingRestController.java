package com.example.kinoxp_backend.controller.movie;

import com.example.kinoxp_backend.dto.movie.MovieShowingDTO;
import com.example.kinoxp_backend.model.movie.MovieShowing;
import com.example.kinoxp_backend.service.movie.MovieHallService;
import com.example.kinoxp_backend.service.movie.MovieService;
import com.example.kinoxp_backend.service.movie.MovieShowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/")
public class MovieShowingRestController {

    @Autowired
    private MovieShowingService movieShowingService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieHallService movieHallService;

    @PostMapping("/movieShowingList")
    public MovieShowing createMovieShowing(@RequestBody MovieShowingDTO movieShowingDTO) {
        return movieShowingService.saveMovieShowing(convertMovieShowingDTO(movieShowingDTO));
    }

    @PutMapping("/movieShowingList/{id}")
    public MovieShowing updateMovieShowing(@PathVariable int id, @RequestBody MovieShowingDTO movieShowingDTO) {
        MovieShowing movieShowing = convertMovieShowingDTO(movieShowingDTO);
        movieShowing.setId(id);
        return movieShowingService.saveMovieShowing(movieShowing);
    }

    @GetMapping("/movieShowingList/range")
    public List<MovieShowing> getMovieShowingsByDateRange(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return movieShowingService.getMovieShowingsByDateRange(startDate, endDate);
    }

    @GetMapping("/movieShowingList")
    public List<MovieShowing> getAllMovieShowings() {
        return movieShowingService.getAllMovieShowings();
    }

    @GetMapping("/movieShowingList/{movieId}")
    public List<MovieShowing> getMovieShowingsByMovieId(@PathVariable int movieId) {
        return movieShowingService.getMovieShowingsByMovieId(movieId);
    }

    private MovieShowing convertMovieShowingDTO(MovieShowingDTO movieShowingDTO) {
        MovieShowing movieShowing = new MovieShowing();
        movieShowing.setMovie(movieService.getMovieById(movieShowingDTO.getMovieId()));
        movieShowing.setMovieHall(movieHallService.getMovieHallById(movieShowingDTO.getMovieHallId()));
        movieShowing.setShowDate(movieShowingDTO.getShowDate());
        movieShowing.setStartTime(movieShowingDTO.getStartTime());
        return movieShowing;
    }
}
