package com.example.levan.practice.service.impl;

import com.example.levan.practice.dto.PositionDTO;
import com.example.levan.practice.entity.Position;
import com.example.levan.practice.exception.ResourceNotFoundException;
import com.example.levan.practice.mapper.PositionMapper;
import com.example.levan.practice.repository.PositionRepository;
import com.example.levan.practice.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {
    private final PositionRepository positionRepository;
    private final PositionMapper positionMapper;

    @Override
    public PositionDTO createPosition(PositionDTO positionCreate) {
        Position position = positionMapper.toPosition(positionCreate);

        return positionMapper.toPositionDTO(positionRepository.save(position));
    }

    @Override
    public List<PositionDTO> getAllPosition() {
        return positionMapper.toListPositionDTO(positionRepository.findAll());
    }

    @Override
    public PositionDTO updatePosition(Long positionId, PositionDTO positionUpdate) {
        Position positionExist = positionRepository.findById(positionId)
                .orElseThrow(() -> new ResourceNotFoundException("A position is not exist !"));

        positionExist.setPositionDescription(positionUpdate.description());
        positionExist.setPositionTitle(positionUpdate.title());

        return positionMapper.toPositionDTO(positionRepository.save(positionExist));
    }

    @Override
    public Void deletePosition(Long positionId) {
        return positionRepository.deleteByPositionId(positionId);
    }
}
