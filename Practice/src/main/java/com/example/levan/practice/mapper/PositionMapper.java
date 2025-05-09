package com.example.levan.practice.mapper;

import com.example.levan.practice.dto.PositionDTO;
import com.example.levan.practice.entity.Position;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PositionMapper {
    PositionMapper INSTANCE = Mappers.getMapper(PositionMapper.class);

    @Mapping(source = "positionTitle", target = "title")
    @Mapping(source = "positionDescription", target = "description")
    PositionDTO toPositionDTO(Position position);

    @Mapping(source = "title", target = "positionTitle")
    @Mapping(source = "description", target = "positionDescription")
    Position toPosition(PositionDTO positionDTO);

    List<PositionDTO> toListPositionDTO(List<Position> positions);
}
