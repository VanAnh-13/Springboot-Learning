package com.example.levan.practice.controller;

import com.example.levan.practice.dto.EmployeeDTO;
import com.example.levan.practice.response.ApiResponse;
import com.example.levan.practice.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
@Validated
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public ApiResponse<EmployeeDTO> createEmployee(@RequestBody @Valid EmployeeDTO employeeCreate) {
        EmployeeDTO employeeCreated = employeeService.createEmployee(employeeCreate);
        return new ApiResponse<>(HttpStatus.CREATED.value(), "Employee created successfully", employeeCreated);
    }

    @GetMapping
    public ApiResponse<List<EmployeeDTO>> getAllEmployee() {
        List<EmployeeDTO> employees = employeeService.getAllEmployee();
        return new ApiResponse<>(HttpStatus.OK.value(), "Employees retrieved successfully", employees);
    }

    @PutMapping("/{id}")
    public ApiResponse<EmployeeDTO> editEmployee(@PathVariable(name = "id") Long employeeId, @RequestBody EmployeeDTO employeeEdit) {
        EmployeeDTO employeeResponse = employeeService.updateEmployee(employeeId, employeeEdit);
        return new ApiResponse<>(HttpStatus.OK.value(), "Employee edit successfully", employeeResponse);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteEmployee(@PathVariable(name = "id") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return new ApiResponse<>(HttpStatus.ACCEPTED.value(), "Employee delete successfully", null);
    }
}
