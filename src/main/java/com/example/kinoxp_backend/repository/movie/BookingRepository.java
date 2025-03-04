package com.example.kinoxp_backend.repository.movie;
import com.example.kinoxp_backend.model.movie.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
