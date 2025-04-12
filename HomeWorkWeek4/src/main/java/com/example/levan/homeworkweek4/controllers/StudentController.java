package com.example.levan.homeworkweek4.controllers;

import com.example.levan.homeworkweek4.models.Student;
import com.example.levan.homeworkweek4.services.StudentServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * REST controller responsible for handling Student-related HTTP requests.
 * Provides endpoints for creating, reading, updating, and deleting Student entities.
 * All endpoints are mapped under the "/students-management" base path.
 */
@RestController
@RequestMapping("/students-management")
@RequiredArgsConstructor
public class StudentController {
    private final StudentServices studentServices;

    @GetMapping("/get-all-students")
    public ResponseEntity<List<Student>> getAllStudent() {
        return ResponseEntity.ok(studentServices.getAllStudent());
    }

    @PutMapping("/edit-student")
    public ResponseEntity<Boolean> editStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentServices.editStudent(student));
    }

    @PostMapping("/create-new-student")
    public ResponseEntity<Boolean> createStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentServices.addStudent(student));
    }

    @DeleteMapping("/delete-student")
    public ResponseEntity<Boolean> deleteStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentServices.deleteStudent(student));
    }

    @GetMapping("/search-student-by-id")
    public ResponseEntity<Student> searchStudentById(@RequestBody Long id) {
        return ResponseEntity.ok(studentServices.searchStudent(id));
    }

    @GetMapping("/search-by-name")
    public ResponseEntity<List<Student>> searchByName(@RequestParam(name = "search_name") String name) {
        return ResponseEntity.ok(studentServices.searchByName(name));
    }
}
