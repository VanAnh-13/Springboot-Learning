package com.example.levan.homeworkweek3.controllers;

import com.example.levan.homeworkweek3.entities.Student;
import com.example.levan.homeworkweek3.services.StudentServicesImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "students-management")
@RequiredArgsConstructor
public class StudentController {
    private final StudentServicesImpl studentServices;

    @GetMapping("/get-all-students")
    public String getAllStudent(HttpServletRequest httpServletRequest) {
        List<Student> students = studentServices.getAllStudent();
        httpServletRequest.setAttribute("students", students);
        return "layout";
    }

    @PostMapping("/create-student")
    public String createStudent(@ModelAttribute Student student, HttpServletRequest httpServletRequest) {
        boolean success = studentServices.addNewStudent(student);

        if (success) {
            httpServletRequest.setAttribute("alert", "Student created successfully!");
        }

        return "redirect:/students-management/get-all-students";
    }

    @PutMapping("/edit-student")
    public String editEmployee(@ModelAttribute Student student, HttpServletRequest httpServletRequest) {
        boolean success = studentServices.editStudent(student);

        if (success) {
            httpServletRequest.setAttribute("alert", "Student updated successfully!");
        } else {
            httpServletRequest.setAttribute("alert", "Failed to update student. Student may not exist.");
        }

        return "redirect:/students-management/get-all-students";
    }

    @DeleteMapping("/delete-student")
    public String deleteStudent(HttpServletRequest httpServletRequest) {
        String id = httpServletRequest.getParameter("id");
        boolean success = studentServices.deleteStudentById(Long.parseLong(id));

        if (success) {
            httpServletRequest.setAttribute("alert", "Student deleted successfully!");
        } else {
            httpServletRequest.setAttribute("alert", "Failed to delete student. Student may not exist.");
        }

        return "redirect:/students-management/get-all-students";
    }
}
