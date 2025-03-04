package com.example.kinoxp_backend.repository;

import com.example.kinoxp_backend.model.ShiftSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftScheduleRepository extends JpaRepository<ShiftSchedule, Integer> {}
