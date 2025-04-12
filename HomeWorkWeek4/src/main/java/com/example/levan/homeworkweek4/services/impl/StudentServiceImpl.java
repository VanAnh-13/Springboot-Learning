package com.example.levan.homeworkweek4.services.impl;

import com.example.levan.homeworkweek4.dto.StudentDTO;
import com.example.levan.homeworkweek4.mapper.StudentMapper;
import com.example.levan.homeworkweek4.models.Student;
import com.example.levan.homeworkweek4.repositories.StudentRepository;
import com.example.levan.homeworkweek4.services.StudentServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    private final StudentMapper studentMapper;


    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public StudentDTO getById(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        return studentMapper.toStudentDTO(student);
    }

    @Override
    public StudentDTO addStudent(StudentDTO studentDTO) throws Exception {
        if (studentRepository.findByPhoneNumber(studentDTO.phoneNumber()).isPresent()) {
            throw new Exception();
        }

        Student studentEntity = studentRepository.save(studentMapper.toEntity(studentDTO));
        return studentMapper.toStudentDTO(studentEntity);
    }

    @Override
    public Optional<StudentDTO> editStudent(Long id, StudentDTO studentReplace) {
        return studentRepository.findById(id)
                .map(studentExist -> {
                    studentRepository.save(studentMapper.updateStudentFromDto(studentExist, studentReplace));
                    return studentMapper.toStudentDTO(studentExist);
                });
    }

    @Override
    public void deleteStudent(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow();

        studentRepository.delete(student);
    }

    @Override
    public List<Student> searchByName(String name) {
        return studentRepository.findByFullNameContainingIgnoreCase(name).orElseThrow();
    }
}
