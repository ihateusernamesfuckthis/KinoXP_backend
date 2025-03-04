package com.example.kinoxp_backend.service.staff;

import com.example.kinoxp_backend.model.staff.ShiftSchedule;
import com.example.kinoxp_backend.repository.staff.ShiftScheduleRepository;
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
