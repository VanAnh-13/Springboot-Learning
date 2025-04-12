package com.example.levan.homeworkweek4.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@Entity(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name", nullable = false)
    @NonNull
    private String fullName;

    @Column(name = "dob")
    private Date dateOfBirth;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "email")
    @NonNull
    private String email;

    @Column(name = "phone")
    @NonNull
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class classId;
}
