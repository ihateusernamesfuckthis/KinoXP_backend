
package com.example.kinoxp_backend.repository;
import com.example.kinoxp_backend.model.MovieHall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieHallRepository extends JpaRepository<MovieHall, Integer> {
}
