package com.example.kinoxp_backend.config;

import com.example.kinoxp_backend.enums.StaffRole;
import com.example.kinoxp_backend.model.Employee;
import com.example.kinoxp_backend.model.Shift;
import com.example.kinoxp_backend.model.ShiftSchedule;
import com.example.kinoxp_backend.repository.EmployeeRepository;
import com.example.kinoxp_backend.repository.ShiftRepository;
import com.example.kinoxp_backend.repository.ShiftScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class ShiftInitData implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ShiftScheduleRepository shiftScheduleRepository;

    @Autowired
    private ShiftRepository shiftRepository;

    @Override
    public void run(String... args) {
        Employee employee1 = new Employee();
        employee1.setName("Alice");
        employee1.setRole(StaffRole.MANAGER);
        employeeRepository.save(employee1);

        Employee employee2 = new Employee();
        employee2.setName("Bob");
        employee2.setRole(StaffRole.STAFF);
        employeeRepository.save(employee2);

        ShiftSchedule schedule = new ShiftSchedule();
        schedule.setWeekNumber(10);
        shiftScheduleRepository.save(schedule);

        Shift shift1 = new Shift();
        shift1.setEmployee(employee1);
        shift1.setDate(LocalDate.now());
        shift1.setStartTime(LocalTime.of(9, 0));
        shift1.setEndTime(LocalTime.of(17, 0));
        shift1.setShiftSchedule(schedule);
        shiftRepository.save(shift1);

        Shift shift2 = new Shift();
        shift2.setEmployee(employee2);
        shift2.setDate(LocalDate.now());
        shift2.setStartTime(LocalTime.of(13, 0));
        shift2.setEndTime(LocalTime.of(21, 0));
        shift2.setShiftSchedule(schedule);
        shiftRepository.save(shift2);
    }
}
