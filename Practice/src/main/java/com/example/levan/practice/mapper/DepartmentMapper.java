package com.example.levan.practice.mapper;

import com.example.levan.practice.dto.DepartmentDTO;
import com.example.levan.practice.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    @Mapping(source = "departmentName", target = "name")
    @Mapping(source = "departmentDescription", target = "description")
    DepartmentDTO toDepartmentDTO(Department department);

    @Mapping(source = "name", target = "departmentName")
    @Mapping(source = "description", target = "departmentDescription")
    Department toDepartment(DepartmentDTO departmentDTO);

    List<DepartmentDTO> toListDepartmentDTO(List<Department> departments);
}
