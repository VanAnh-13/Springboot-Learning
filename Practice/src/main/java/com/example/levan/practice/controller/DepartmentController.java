package com.example.levan.practice.controller;

import com.example.levan.practice.dto.DepartmentDTO;
import com.example.levan.practice.response.ApiResponse;
import com.example.levan.practice.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/department")
@RequiredArgsConstructor
@Validated
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping
    public ApiResponse<DepartmentDTO> createDepartment(@RequestBody @Valid DepartmentDTO departmentInput) {
        DepartmentDTO departmentOutput = departmentService.createDepartment(departmentInput);
        return new ApiResponse<>(HttpStatus.CREATED.value(), "Department created successfully", departmentOutput);
    }

    @GetMapping
    public ApiResponse<List<DepartmentDTO>> getAllDepartment() {
        List<DepartmentDTO> departments = departmentService.getAllDepartment();
        return new ApiResponse<>(HttpStatus.OK.value(), "Department got successfully", departments);
    }

    @PutMapping("/{id}")
    public ApiResponse<DepartmentDTO> updateDepartment(@PathVariable(name = "id") Long departmentId, @RequestBody @Valid DepartmentDTO departmentEdit) {
        DepartmentDTO departmentEditResult = departmentService.updateDepartment(departmentId, departmentEdit);
        return new ApiResponse<>(HttpStatus.OK.value(), "Department edited successfully", departmentEditResult);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteDepartment(@PathVariable(name = "id") Long departmentId) {
        departmentService.deleteDepartment(departmentId);
        return new ApiResponse<>(HttpStatus.NO_CONTENT.value(), "Department deleted successfully", null);
    }
}
