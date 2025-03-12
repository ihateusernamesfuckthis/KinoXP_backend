package com.example.kinoxp_backend.repository.movie;

import com.example.kinoxp_backend.model.movie.MovieShowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieShowingRepository extends JpaRepository<MovieShowing, Integer> {
    List<MovieShowing> findByMovieId(int movieId);
}
