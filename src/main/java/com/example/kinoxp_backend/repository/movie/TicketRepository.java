package com.example.kinoxp_backend.repository.movie;

import com.example.kinoxp_backend.model.movie.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
