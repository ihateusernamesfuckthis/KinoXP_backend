package com.example.kinoxp_backend.repository;

import com.example.kinoxp_backend.model.MovieShowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieShowingRepository extends JpaRepository<MovieShowing, Integer> {
}