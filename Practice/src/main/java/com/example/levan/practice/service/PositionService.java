package com.example.levan.practice.service;

import com.example.levan.practice.dto.PositionDTO;

import java.util.List;

public interface PositionService {
    PositionDTO createPosition(PositionDTO positionCreate);

    List<PositionDTO> getAllPosition();

    PositionDTO updatePosition(Long positionId, PositionDTO positionUpdate);

    Void deletePosition(Long positionId);
}
