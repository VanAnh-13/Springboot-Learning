package com.example.levan.homeworkweek4.controllers;

import com.example.levan.homeworkweek4.dto.StudentDTO;
import com.example.levan.homeworkweek4.models.Student;
import com.example.levan.homeworkweek4.services.StudentServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;


@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentServices studentServices;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent() {
        return ResponseEntity.ok(studentServices.getAllStudent()
                .stream()
                .sorted(Comparator.comparingLong(Student::getId))
                .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> searchStudentById(@PathVariable(name = "id") Long studentId) {
        return ResponseEntity.ok(studentServices.getById(studentId));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Student>> searchByName(@RequestParam(name = "search_name") String name) {
        return ResponseEntity.ok(studentServices.searchByName(name));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> editStudent(@PathVariable Long id, @RequestBody StudentDTO studentDTO) {
        return studentServices.editStudent(id, studentDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO) throws Exception {
        return new ResponseEntity<>(studentServices.addStudent(studentDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable(name = "id") Long studentId) {
        studentServices.deleteStudent(studentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
