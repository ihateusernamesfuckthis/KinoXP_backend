package com.example.kinoxp_backend.service;

import com.example.kinoxp_backend.model.Shift;
import com.example.kinoxp_backend.repository.ShiftRepository;
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
