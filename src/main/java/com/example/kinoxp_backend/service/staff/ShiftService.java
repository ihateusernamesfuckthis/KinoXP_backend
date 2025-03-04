package com.example.kinoxp_backend.service.staff;

import com.example.kinoxp_backend.model.staff.Shift;
import com.example.kinoxp_backend.repository.staff.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class ShiftService {
    @Autowired
    private ShiftRepository shiftRepository;

    public Shift saveShift(Shift shift) {
        return shiftRepository.save(shift);
    }

    public List<Shift> getAllShifts() {
        return shiftRepository.findAll();
    }
}
