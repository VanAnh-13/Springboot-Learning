package com.example.levan.practice.controller;

import com.example.levan.practice.dto.PositionDTO;
import com.example.levan.practice.response.ApiResponse;
import com.example.levan.practice.service.PositionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/positions")
@Validated
@RequiredArgsConstructor
public class PositionController {
    private final PositionService positionService;

    @PostMapping
    public ApiResponse<PositionDTO> createUser(@Valid @RequestBody PositionDTO positionCreate) {
        PositionDTO positionCreated = positionService.createPosition(positionCreate);
        return new ApiResponse<>(HttpStatus.CREATED.value(), "Position created successfully", positionCreated);
    }

    @GetMapping
    public ApiResponse<List<PositionDTO>> getAllPositions() {
        List<PositionDTO> positionDTOS = positionService.getAllPosition();
        return new ApiResponse<>(HttpStatus.OK.value(), "Position retrieved successfully", positionDTOS);
    }

    @PutMapping("/{id}")
    public ApiResponse<PositionDTO> updateUser(@PathVariable(name = "id") Long positionId, @Valid @RequestBody PositionDTO positionUpdate) {
        PositionDTO positionUpdated = positionService.updatePosition(positionId, positionUpdate);
        return new ApiResponse<>(HttpStatus.OK.value(), "Position updated successfully", positionUpdated);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteUser(@PathVariable(name = "id") Long positionId) {
        positionService.deletePosition(positionId);
        return new ApiResponse<>(HttpStatus.OK.value(), "Position deleted successfully", null);
    }
}
