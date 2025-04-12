package com.example.levan.homeworkweek4.services;

import com.example.levan.homeworkweek4.dto.StudentDTO;
import com.example.levan.homeworkweek4.models.Student;

import java.util.List;
import java.util.Optional;


/**
 * Interface for Student Services.
 * Provides methods for managing students.
 * <p>
 * Methods:
 * - `List<Student> getAllStudent()`: Retrieves a list of all students.
 * - `StudentDTO getById(Long studentId)`: Get a student by ID and returns it as a DTO if found.
 * - `StudentDTO addStudent(StudentDTO student)`: Adds a new student and returns the added student as a DTO.
 * - `Optional<StudentDTO> editStudent(Long id, StudentDTO student)`: Edits an existing student by ID and returns the updated student as a DTO.
 * - `void deleteStudent(Long id)`: Deletes a student by ID.
 * - `List<Student> searchByName(String name)`: Searches for students by name and returns a list of matching students.
 */
public interface StudentServices {
    List<Student> getAllStudent();

    StudentDTO getById(Long studentId);

    StudentDTO addStudent(StudentDTO student) throws Exception;

    Optional<StudentDTO> editStudent(Long id, StudentDTO student);

    void deleteStudent(Long studentId);

    List<Student> searchByName(String name);
}
