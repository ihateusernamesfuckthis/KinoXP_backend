package com.example.kinoxp_backend.repository.movie;

import com.example.kinoxp_backend.model.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
