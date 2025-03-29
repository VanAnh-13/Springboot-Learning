package com.example.levan.homeworkweek3.services;

import com.example.levan.homeworkweek3.entities.Student;
import com.example.levan.homeworkweek3.repositories.StudentManagementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServicesImpl implements StudentServices {
    private final StudentManagementRepository studentManagementRepository;

    private boolean isExistStudent(Long id) {
        return studentManagementRepository.existsById(id);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentManagementRepository.findAll();
    }

    @Override
    public boolean addNewStudent(Student student) {
        studentManagementRepository.save(student);
        return true;
    }

    @Override
    public boolean editStudent(Student student) {
        if (isExistStudent(student.getId())) {
            studentManagementRepository.save(student);
            return true;
        }

        return false;
    }

    @Override
    public boolean deleteStudentById(Long studentId) {
        if (isExistStudent(studentId)) {
            studentManagementRepository.deleteById(studentId);
            return true;
        }

        return false;
    }
}
