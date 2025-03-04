
package com.example.kinoxp_backend.repository.movie;
import com.example.kinoxp_backend.model.movie.MovieHall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieHallRepository extends JpaRepository<MovieHall, Integer> {
}
