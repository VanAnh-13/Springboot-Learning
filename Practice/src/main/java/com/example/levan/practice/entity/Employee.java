package com.example.levan.practice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long employeeId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "user_id",
            unique = true,
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "fk_user_id",
                    foreignKeyDefinition = "FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE"
            )
    )
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "department_id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "fk_department_id",
                    foreignKeyDefinition = "FOREIGN KEY (department_id) REFERENCES departments(id) ON DELETE SET NULL"
            )
    )
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "position_id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "fk_position_id",
                    foreignKeyDefinition = "FOREIGN KEY (position_id) REFERENCES positions(id) ON DELETE SET NULL"
            )
    )
    private Position position;

    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "hired_date")
    private LocalDate hiredDate;

    @Column(name = "salary", precision = 10, scale = 2)
    private BigDecimal salary;
}
