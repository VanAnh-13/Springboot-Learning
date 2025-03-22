package com.example.levan.homeworkweek2.repositories;

import com.example.levan.homeworkweek2.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
