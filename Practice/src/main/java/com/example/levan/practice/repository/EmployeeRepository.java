package com.example.levan.practice.repository;

import com.example.levan.practice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Void deleteByEmployeeId(Long employeeId);
    
    // Find employee by user ID
    Employee findByUserUserId(Long userId);
}
