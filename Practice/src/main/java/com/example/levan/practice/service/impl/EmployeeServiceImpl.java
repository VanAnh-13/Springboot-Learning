package com.example.levan.practice.service.impl;

import com.example.levan.practice.dto.EmployeeDTO;
import com.example.levan.practice.entity.Department;
import com.example.levan.practice.entity.Employee;
import com.example.levan.practice.entity.Position;
import com.example.levan.practice.entity.User;
import com.example.levan.practice.exception.ResourceNotFoundException;
import com.example.levan.practice.mapper.EmployeeMapper;
import com.example.levan.practice.repository.DepartmentRepository;
import com.example.levan.practice.repository.EmployeeRepository;
import com.example.levan.practice.repository.PositionRepository;
import com.example.levan.practice.repository.UserRepository;
import com.example.levan.practice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final PositionRepository positionRepository;
    private final UserRepository userRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeCreate) {
        if (employeeCreate.userId() != null) {
            Employee existingEmployee = employeeRepository.findByUserUserId(employeeCreate.userId());
            if (existingEmployee != null) {
                throw new IllegalArgumentException("A user can only be associated with one employee. User ID " + 
                    employeeCreate.userId() + " already has an employee record.");
            }
        }
        
        Employee employeeInput = employeeMapper.toEmployee(employeeCreate);
        
        if (employeeCreate.userId() != null) {
            User user = userRepository.findById(employeeCreate.userId())
                .orElseThrow(() -> new ResourceNotFoundException("A user is not found !"));
            employeeInput.setUser(user);
        }

        isExistingDepartment(employeeCreate, employeeInput);

        return employeeMapper.toEmployeeDTO(employeeRepository.save(employeeInput));
    }

    private void isExistingDepartment(EmployeeDTO employeeCreate, Employee employeeInput) {
        if (employeeCreate.departmentId() != null) {
            Department department = departmentRepository.findById(employeeCreate.departmentId())
                .orElseThrow(() -> new ResourceNotFoundException("A department is not found !"));
            employeeInput.setDepartment(department);
        }

        if (employeeCreate.positionId() != null) {
            Position position = positionRepository.findById(employeeCreate.positionId())
                .orElseThrow(() -> new ResourceNotFoundException("A position is not found !"));
            employeeInput.setPosition(position);
        }
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        return employeeMapper.toListEmployeeDTO(employeeRepository.findAll());
    }

    @Override
    public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO employeeUpdate) {
        Employee employeeExist = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("An employee is not found !"));

        employeeExist.setSalary(employeeUpdate.salary());
        employeeExist.setDateOfBirth(employeeUpdate.dateOfBirth());
        employeeExist.setFullName(employeeUpdate.fullName());
        employeeExist.setHiredDate(employeeUpdate.hiredDate());

        isExistingDepartment(employeeUpdate, employeeExist);

        // Update user if userId has changed
        if (employeeUpdate.userId() != null && 
            (employeeExist.getUser() == null || !employeeExist.getUser().getUserId().equals(employeeUpdate.userId()))) {
            
            // Check if the new user is already assigned to another employee
            Employee existingEmployee = employeeRepository.findByUserUserId(employeeUpdate.userId());
            if (existingEmployee != null && !existingEmployee.getEmployeeId().equals(employeeId)) {
                throw new IllegalArgumentException("User ID " + employeeUpdate.userId() + 
                    " is already associated with another employee. A user can only be assigned to one employee.");
            }
            
            User userExist = userRepository.findById(employeeUpdate.userId())
                    .orElseThrow(() -> new ResourceNotFoundException("A user is not found !"));
            employeeExist.setUser(userExist);
        }

        return employeeMapper.toEmployeeDTO(employeeRepository.save(employeeExist));
    }

    @Override
    public Void deleteEmployee(Long employeeId) {
        return employeeRepository.deleteByEmployeeId(employeeId);
    }
}
