package com.example.levan.homeworkweek4.services;

import com.example.levan.homeworkweek4.models.Student;

import java.util.List;


/**
 * Interface for Student Services.
 * Provides methods for managing students.
 * <p>
 * Methods:
 * - List\<Student\> getAllStudent(): Retrieves a list of all students.
 * - Boolean addStudent(Student student): Adds a new student.
 * - Boolean editStudent(Student student): Edits an existing student.
 * - Boolean deleteStudent(Student student): Deletes a student.
 * - Student searchStudent(Long studentId): Searches for a student by ID.
 */
public interface StudentServices {
    List<Student> getAllStudent();

    Boolean addStudent(Student student);

    Boolean editStudent(Student student);

    Boolean deleteStudent(Student student);

    Student searchStudent(Long studentId);

    List<Student> searchByName(String name);
}
