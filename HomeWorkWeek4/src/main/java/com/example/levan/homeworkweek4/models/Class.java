package com.example.levan.homeworkweek4.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Entity(name = "classes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "class_id")
    private Long id;

    @Column(name = "name")
    @NonNull
    private String className;

    @Column(name = "subject")
    @NonNull
    private String classSubject;
}
