package com.example.kinoxp_backend.service.staff;

import com.example.kinoxp_backend.model.staff.ShiftSchedule;
import com.example.kinoxp_backend.repository.staff.ShiftScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiftScheduleService {
    @Autowired
    private ShiftScheduleRepository shiftScheduleRepository ;

    public ShiftSchedule saveShiftSchedule(ShiftSchedule shiftSchedule) {
        return shiftScheduleRepository.save(shiftSchedule);
    }

    public List<ShiftSchedule> getAllShiftSchedules() {
        return shiftScheduleRepository.findAll();
    }

    public ShiftSchedule getShiftScheduleById(int id) {
        return shiftScheduleRepository.findById(id).orElse(null);
    }

    public void deleteShiftSchedule(int id) {
        shiftScheduleRepository.deleteById(id);
    }

    public ShiftSchedule updateShiftSchedule(int id, ShiftSchedule updatedShiftSchedule) {
        return shiftScheduleRepository.findById(id).map(shiftSchedule -> {
            shiftSchedule.setWeekNumber(updatedShiftSchedule.getWeekNumber());
            shiftSchedule.setShiftList(updatedShiftSchedule.getShiftList());
            return shiftScheduleRepository.save(shiftSchedule);
        }).orElse(null);
    }

    public ShiftSchedule findByWeekNumber(int weekNumber) {
        return shiftScheduleRepository.findByWeekNumber(weekNumber);
    }
}
