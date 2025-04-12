package com.example.levan.homeworkweek4.mapper;

import com.example.levan.homeworkweek4.dto.StudentDTO;
import com.example.levan.homeworkweek4.models.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDTO toStudentDTO(Student student);

    Student toEntity(StudentDTO studentDTO);

    @Mapping(target = "id", ignore = true)
    Student updateStudentFromDto(@MappingTarget Student studentUpdate, StudentDTO currentStudent);
}
