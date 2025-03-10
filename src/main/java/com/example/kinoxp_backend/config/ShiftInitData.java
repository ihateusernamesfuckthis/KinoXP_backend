package com.example.kinoxp_backend.config;

import com.example.kinoxp_backend.enums.StaffRole;
import com.example.kinoxp_backend.model.staff.Employee;
import com.example.kinoxp_backend.model.staff.Shift;
import com.example.kinoxp_backend.repository.staff.EmployeeRepository;
import com.example.kinoxp_backend.repository.staff.ShiftRepository;
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

        Employee employee3 = new Employee();
        employee3.setName("Kate");
        employee3.setRole(StaffRole.STAFF);
        employeeRepository.save(employee3);


        Shift shift1 = new Shift();
        shift1.setEmployee(employee1);
        shift1.setDate(LocalDate.now());
        shift1.setStartTime(LocalTime.of(9, 0));
        shift1.setEndTime(LocalTime.of(17, 0));
        shiftRepository.save(shift1);

        Shift shift2 = new Shift();
        shift2.setEmployee(employee3);
        shift2.setDate(LocalDate.now());
        shift2.setStartTime(LocalTime.of(13, 0));
        shift2.setEndTime(LocalTime.of(21, 0));
        shiftRepository.save(shift2);
    }
}
