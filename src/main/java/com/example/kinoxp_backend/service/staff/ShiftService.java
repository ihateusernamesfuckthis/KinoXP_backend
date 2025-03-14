package com.example.kinoxp_backend.service.staff;

import com.example.kinoxp_backend.model.staff.Shift;
import com.example.kinoxp_backend.repository.staff.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ShiftService {
    @Autowired
    private ShiftRepository shiftRepository;

    public Shift saveShift(Shift shift) {
        return shiftRepository.save(shift);
    }

    public List<Shift> getAllShifts() {
        return shiftRepository.findAll();
    }


    public List<Shift> getShiftsByEmployeeIdAndDateRange(int employeeId, LocalDate startDate, LocalDate endDate) {
        return shiftRepository.findByEmployee_IdAndDateBetween(employeeId, startDate, endDate);
    }

    public List<Shift> getShiftsByDateRange(LocalDate startDate, LocalDate endDate) {
        return shiftRepository.findByDateBetween(startDate, endDate);
    }

    public Shift getShiftById(int id) {
        return shiftRepository.findById(id).orElse(null);
    }

    public void deleteShift(int id) {
        shiftRepository.deleteById(id);
    }

    public Shift updateShift(int id, Shift updatedShift) {
        return shiftRepository.findById(id).map(shift -> {
            shift.setEmployee(updatedShift.getEmployee());
            shift.setDate(updatedShift.getDate());
            shift.setStartTime(updatedShift.getStartTime());
            shift.setEndTime(updatedShift.getEndTime());
            return shiftRepository.save(shift);
        }).orElse(null);
    }
}
