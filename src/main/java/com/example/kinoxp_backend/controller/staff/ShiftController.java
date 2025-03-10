package com.example.kinoxp_backend.controller.staff;

import com.example.kinoxp_backend.dto.staff.ShiftDTO;
import com.example.kinoxp_backend.model.staff.Employee;
import com.example.kinoxp_backend.model.staff.Shift;
import com.example.kinoxp_backend.service.staff.EmployeeService;
import com.example.kinoxp_backend.service.staff.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.List;

@RestController
@RequestMapping("/api/shifts")
public class ShiftController {

    @Autowired
    private ShiftService shiftService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Shift> getAllShifts() {
        return shiftService.getAllShifts();
    }

    @GetMapping("/range")
    public List<Shift> getShiftsByDateRange(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return shiftService.getShiftsByDateRange(startDate, endDate);
    }

    @GetMapping("/{id}")
    public Shift getShiftById(@PathVariable int id) {
        return shiftService.getShiftById(id);
    }

    @PostMapping
    public Shift saveShift(@RequestBody ShiftDTO shiftDTO) {
        Shift shift = convertShiftDTOtoShift(shiftDTO);
        return shiftService.saveShift(shift);
    }

    @PutMapping("/{id}")
    public Shift updateShift(@PathVariable int id, @RequestBody ShiftDTO shiftDTO) {
        Shift shift = convertShiftDTOtoShift(shiftDTO);
        return shiftService.updateShift(id, shift);
    }

    @DeleteMapping("/{id}")
    public void deleteShift(@PathVariable int id) {
        shiftService.deleteShift(id);
    }


    private Shift convertShiftDTOtoShift(ShiftDTO shiftDTO) {
        Employee employee = employeeService.getEmployeeById(shiftDTO.getEmployeeId()).isPresent() ? employeeService.getEmployeeById(shiftDTO.getEmployeeId()).get() : null;
        Shift shift = new Shift();
        shift.setEmployee(employee);
        shift.setDate(shiftDTO.getDate());
        shift.setStartTime(shiftDTO.getStartTime());
        shift.setEndTime(shiftDTO.getEndTime());
        return shift;
    }
}
