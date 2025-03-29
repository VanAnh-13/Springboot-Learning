package com.example.levan.homeworkweek3.services;

import com.example.levan.homeworkweek3.entities.Student;

import java.util.List;

public interface StudentServices {
    List<Student> getAllStudent();

    boolean addNewStudent(Student student);

    boolean editStudent(Student student);

    boolean deleteStudentById(Long studentId);
}
