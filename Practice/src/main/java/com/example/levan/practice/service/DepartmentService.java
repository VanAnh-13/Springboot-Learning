package com.example.levan.practice.service;

import com.example.levan.practice.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {
    DepartmentDTO createDepartment(DepartmentDTO departmentCreate);

    List<DepartmentDTO> getAllDepartment();

    DepartmentDTO updateDepartment(Long departmentId, DepartmentDTO departmentUpdate);

    Void deleteDepartment(Long departmentId);
}
