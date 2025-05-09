package com.example.levan.practice.repository;

import com.example.levan.practice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Void deleteByDepartmentId(Long departmentId);
}
