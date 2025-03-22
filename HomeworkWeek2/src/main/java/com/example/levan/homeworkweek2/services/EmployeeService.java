package com.example.levan.homeworkweek2.services;

import com.example.levan.homeworkweek2.entities.Employee;
import com.example.levan.homeworkweek2.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void editEmployee(Employee employee) {
        employeeRepository.findById(employee.getId()).ifPresent(employeeExists -> employeeRepository.save(employee));
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public void deleteAllEmployee() {
        employeeRepository.deleteAll();
    }
}
