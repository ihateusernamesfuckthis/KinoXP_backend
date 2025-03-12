package com.example.kinoxp_backend.controller.movie;

import com.example.kinoxp_backend.model.movie.MovieSeat;
import com.example.kinoxp_backend.model.movie.MovieShowing;
import com.example.kinoxp_backend.service.movie.MovieSeatService;
import com.example.kinoxp_backend.service.movie.MovieShowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
public class bookingRestController {

        @Autowired
        private MovieSeatService movieSeatService;

        @Autowired
        private MovieShowingService movieShowingService;

        @GetMapping("/{showingId}")
        public ResponseEntity<List<MovieSeat>> getBookedSeats(@PathVariable int showingId) {
                List<MovieSeat> bookedSeats = movieSeatService.findByMovieShowingId(showingId);
                return ResponseEntity.ok(bookedSeats);
        }

        @Transactional
        @PostMapping("/{showingId}")
        public ResponseEntity<MovieShowing> createBookedSeats(@PathVariable int showingId, @RequestBody List<MovieSeat> updatedSeats) {
                MovieShowing movieShowing = movieShowingService.findById(showingId)
                        .orElseThrow(() -> new RuntimeException("MovieShowing not found with id " + showingId));


                for (MovieSeat updatedSeat : updatedSeats) {
                        MovieSeat existingSeat = movieShowing.getSeats().stream()
                                .filter(seat -> seat.getRowsNumber() == updatedSeat.getRowsNumber() && seat.getSeatNumber() == updatedSeat.getSeatNumber())
                                .findFirst()
                                .orElseGet(() -> {
                                        MovieSeat newSeat = new MovieSeat();
                                        newSeat.setRowsNumber(updatedSeat.getRowsNumber());
                                        newSeat.setSeatNumber(updatedSeat.getSeatNumber());
                                        newSeat.setIsBooked(updatedSeat.isBooked());
                                        newSeat.setMovieShowing(movieShowing);
                                        movieShowing.getSeats().add(newSeat);
                                        return newSeat;
                                });

                        existingSeat.setIsBooked(updatedSeat.isBooked());
                        movieSeatService.saveSeat(existingSeat);
                }


                MovieShowing updatedMovieShowing = movieShowingService.save(movieShowing);
                return ResponseEntity.ok(updatedMovieShowing);
        }
}
