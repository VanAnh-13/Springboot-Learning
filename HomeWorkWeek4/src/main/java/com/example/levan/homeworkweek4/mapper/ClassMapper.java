package com.example.levan.homeworkweek4.mapper;

import com.example.levan.homeworkweek4.dto.ClassDTO;
import com.example.levan.homeworkweek4.models.Class;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClassMapper {
    Class toClass(ClassDTO classDTO);

    ClassDTO toEntity(Class classEntity);
}
