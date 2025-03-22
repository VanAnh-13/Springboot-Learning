package com.example.levan.homeworkweek2.controllers;

import com.example.levan.homeworkweek2.entities.Employee;
import com.example.levan.homeworkweek2.services.EmployeeService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping(value = "/get-all-employees")
    public String getAllEmployees(HttpServletRequest httpServletRequest) {
        List<Employee> employees = employeeService.getAllEmployees();
        httpServletRequest.setAttribute("employees", employees);
        return "layout";
    }

    @GetMapping(value = "/delete-employee")
    public String deleteEmployee(@RequestParam Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:get-all-employees";
    }

    @GetMapping(value = "/delete-all-employee")
    public String deleteAllEmployees() {
        employeeService.deleteAllEmployee();
        return "redirect:get-all-employees";
    }

    @PostMapping(value = "/edit-employee")
    public String editEmployee(@RequestParam Long id, @ModelAttribute Employee employee) {
        employee.setId(id);
        employeeService.editEmployee(employee);
        return "redirect:get-all-employees";
    }

    @PostMapping(value = "/create-employee")
    public String createEmployee(@ModelAttribute Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:get-all-employees";
    }
}
