package com.example.kinoxp_backend.repository.staff;

import com.example.kinoxp_backend.model.staff.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ShiftRepository extends JpaRepository<Shift, Integer> {
    List<Shift> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
