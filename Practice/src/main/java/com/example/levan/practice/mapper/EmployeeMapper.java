package com.example.levan.practice.mapper;

import com.example.levan.practice.dto.EmployeeDTO;
import com.example.levan.practice.entity.Department;
import com.example.levan.practice.entity.Employee;
import com.example.levan.practice.entity.Position;
import com.example.levan.practice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mapping(source = "department", target = "departmentId")
    @Mapping(source = "user", target = "userId")
    @Mapping(source = "position", target = "positionId")
    EmployeeDTO toEmployeeDTO(Employee employee);

    @Mapping(source = "departmentId", target = "department")
    @Mapping(source = "userId", target = "user")
    @Mapping(source = "positionId", target = "position")
    Employee toEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO> toListEmployeeDTO(List<Employee> employees);

    default Long map(Department department) {
        return department != null ? department.getDepartmentId() : null;
    }

    default Long map(User user) {
        return user != null ? user.getUserId() : null;
    }

    default Long map(Position position) {
        return position != null ? position.getPositionId() : null;
    }

    // These methods are used by MapStruct when converting from DTOs to entities
    default Department mapDepartment(Long departmentId) {
        if (departmentId == null) {
            return null;
        }
        Department department = new Department();
        department.setDepartmentId(departmentId);
        return department;
    }

    default User mapUser(Long userId) {
        if (userId == null) {
            return null;
        }
        User user = new User();
        user.setUserId(userId);
        return user;
    }

    default Position mapPosition(Long positionId) {
        if (positionId == null) {
            return null;
        }

        Position position = new Position();
        position.setPositionId(positionId);

        return position;
    }
}
