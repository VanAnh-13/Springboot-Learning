package com.example.levan.practice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "departments")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long departmentId;

    @Column(name = "name", nullable = false, unique = true, length = 100)
    private String departmentName;

    @Column(name = "description")
    private String departmentDescription;
}
