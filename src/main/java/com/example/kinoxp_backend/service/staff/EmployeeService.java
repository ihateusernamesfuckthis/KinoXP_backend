package com.example.kinoxp_backend.service.staff;

import com.example.kinoxp_backend.model.staff.Employee;
import com.example.kinoxp_backend.repository.staff.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }
}
