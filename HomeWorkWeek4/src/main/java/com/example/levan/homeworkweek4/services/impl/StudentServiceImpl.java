package com.example.levan.homeworkweek4.services.impl;

import com.example.levan.homeworkweek4.models.Student;
import com.example.levan.homeworkweek4.repositories.StudentRepository;
import com.example.levan.homeworkweek4.services.StudentServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the StudentServices interface that provides CRUD operations for Student entities.
 * This service class handles the business logic for student management:
 * - Retrieving all students from the database
 * - Adding new students (only if the student ID doesn't already exist)
 * - Editing existing student information
 * - Deleting students from the database
 * - Searching for students by their ID
 * This implementation uses a {@link StudentRepository} to interact with the database.
 */
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentServices {
    private final StudentRepository studentRepository;

    private Student isExist(Long studentId) {
        if (studentId == null) {
            return null;
        }

        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public Boolean isExistByEmail(String email) {
        return studentRepository.findByEmail(email).isPresent();
    }

    public Boolean addStudent(Student student) {
        if (isExistByEmail(student.getEmail())) {
            return false;
        }

        student.setId(null);
        studentRepository.save(student);
        return true;
    }

    @Override
    public Boolean editStudent(Student student) {
        boolean studentExist = isExist(student.getId()) != null;
        if (studentExist) {
            studentRepository.save(student);
            return true;
        }

        return false;
    }

    @Override
    public Boolean deleteStudent(Student student) {
        boolean studentExist = isExist(student.getId()) != null;
        if (!studentExist) {
            return false;
        }

        studentRepository.delete(student);
        return true;
    }

    @Override
    public Student searchStudent(Long studentId) {
        Student student = isExist(studentId);

        return student == null ? new Student() : student;
    }

    @Override
    public List<Student> searchByName(String name) {
        return studentRepository.findByFullNameContainingIgnoreCase(name).orElse(new ArrayList<>());
    }
}
