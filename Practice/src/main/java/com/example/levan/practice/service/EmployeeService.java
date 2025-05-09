package com.example.levan.practice.service;

import com.example.levan.practice.dto.EmployeeDTO;
import com.example.levan.practice.entity.Employee;
import com.example.levan.practice.entity.User;
import com.example.levan.practice.repository.EmployeeRepository;
import com.example.levan.practice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface EmployeeService {

    EmployeeDTO createEmployee(EmployeeDTO employeeCreate);

    List<EmployeeDTO> getAllEmployee();

    EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO employeeUpdate);

    Void deleteEmployee(Long employeeId);

}