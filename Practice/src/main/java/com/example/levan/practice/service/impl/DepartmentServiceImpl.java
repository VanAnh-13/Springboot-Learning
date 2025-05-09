package com.example.levan.practice.service.impl;

import com.example.levan.practice.dto.DepartmentDTO;
import com.example.levan.practice.entity.Department;
import com.example.levan.practice.exception.ResourceNotFoundException;
import com.example.levan.practice.mapper.DepartmentMapper;
import com.example.levan.practice.repository.DepartmentRepository;
import com.example.levan.practice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    @Override
    public DepartmentDTO createDepartment(DepartmentDTO departmentCreate) {
        Department departmentInput = departmentMapper.toDepartment(departmentCreate);
        return departmentMapper.toDepartmentDTO(departmentRepository.save(departmentInput));
    }

    @Override
    public List<DepartmentDTO> getAllDepartment() {
        return departmentMapper.toListDepartmentDTO(departmentRepository.findAll());
    }

    @Override
    public DepartmentDTO updateDepartment(Long departmentId, DepartmentDTO departmentUpdate) {
        Department departmentExist = departmentRepository.findById(departmentId).orElseThrow(() -> new ResourceNotFoundException("A department is not exist !"));

        departmentExist.setDepartmentName(departmentExist.getDepartmentName());
        departmentExist.setDepartmentDescription(departmentExist.getDepartmentDescription());

        return departmentMapper.toDepartmentDTO(departmentRepository.save(departmentExist));
    }

    @Override
    public Void deleteDepartment(Long departmentId) {
        return departmentRepository.deleteByDepartmentId(departmentId);
    }
}
