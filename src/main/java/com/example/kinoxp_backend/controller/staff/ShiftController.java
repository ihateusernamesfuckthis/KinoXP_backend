package com.example.kinoxp_backend.controller.staff;

import com.example.kinoxp_backend.dto.staff.ShiftDTO;
import com.example.kinoxp_backend.model.staff.Employee;
import com.example.kinoxp_backend.model.staff.Shift;
import com.example.kinoxp_backend.model.staff.ShiftSchedule;
import com.example.kinoxp_backend.service.staff.EmployeeService;
import com.example.kinoxp_backend.service.staff.ShiftScheduleService;
import com.example.kinoxp_backend.service.staff.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.temporal.ChronoField;
import java.util.List;

@RestController
@RequestMapping("/api/shifts")
public class ShiftController {

    @Autowired
    private ShiftService shiftService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ShiftScheduleService shiftScheduleService;

    @GetMapping
    public List<Shift> getAllShifts() {
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        return shiftService.getAllShifts();
    }

    @GetMapping("/{id}")
    public Shift getShiftById(@PathVariable int id) {
        return shiftService.getShiftById(id);
    }

    @PostMapping
    public Shift saveShift(@RequestBody ShiftDTO shiftDTO) {
        Employee employee = employeeService.getEmployeeById(shiftDTO.getEmployeeId()).isPresent() ? employeeService.getEmployeeById(shiftDTO.getEmployeeId()).get() : null;
        int weekNumber = shiftDTO.getDate().get(ChronoField.ALIGNED_WEEK_OF_YEAR);
        ShiftSchedule shiftSchedule = shiftScheduleService.findByWeekNumber(weekNumber);

        Shift shift = new Shift();
        shift.setEmployee(employee);
        shift.setDate(shiftDTO.getDate());
        shift.setStartTime(shiftDTO.getStartTime());
        shift.setEndTime(shiftDTO.getEndTime());
        shift.setShiftSchedule(shiftSchedule);
        return shiftService.saveShift(shift);
    }

    @PutMapping("/{id}")
    public Shift updateShift(@PathVariable int id, @RequestBody Shift shift) {
        return shiftService.updateShift(id, shift);
    }

    @DeleteMapping("/{id}")
    public void deleteShift(@PathVariable int id) {
        shiftService.deleteShift(id);
    }

}
