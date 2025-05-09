package com.example.levan.practice.repository;

import com.example.levan.practice.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
    Void deleteByPositionId(Long id);
}
