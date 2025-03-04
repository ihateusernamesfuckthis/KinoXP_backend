package com.example.kinoxp_backend.repository.staff;

import com.example.kinoxp_backend.model.staff.ShiftSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftScheduleRepository extends JpaRepository<ShiftSchedule, Integer> {}
