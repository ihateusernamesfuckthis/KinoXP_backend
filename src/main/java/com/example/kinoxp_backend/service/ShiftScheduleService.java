package com.example.kinoxp_backend.service;

import com.example.kinoxp_backend.model.ShiftSchedule;
import com.example.kinoxp_backend.repository.ShiftScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class ShiftScheduleService {
    @Autowired
    private ShiftScheduleRepository shiftScheduleRepository ;

    public ShiftSchedule saveShiftSchedule(ShiftSchedule shiftSchedule) {
        return shiftScheduleRepository.save(shiftSchedule);
    }

    public List<ShiftSchedule> getAllShiftSchedules() {
        return shiftScheduleRepository.findAll();
    }
}
