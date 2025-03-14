package com.example.kinoxp_backend.repository.movie;
import com.example.kinoxp_backend.model.movie.MovieSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieSeatRepository extends JpaRepository<MovieSeat, Integer> {
    List<MovieSeat> findByMovieShowingId(int showingId);

    Optional<MovieSeat> findByMovieShowingIdAndRowsNumberAndSeatNumber(int showingId, int rowsNumber, int seatNumber);
}