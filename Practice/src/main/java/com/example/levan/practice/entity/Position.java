package com.example.levan.practice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "positions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Long positionId;

    @Column(name = "title", nullable = false, unique = true, length = 100)
    private String positionTitle;

    @Column(name = "description")
    private String positionDescription;
}
