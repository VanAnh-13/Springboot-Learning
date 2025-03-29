package com.example.levan.homeworkweek3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {
    @GetMapping("/home")
    public String returnToHome() {
        return "redirect:students-management/get-all-students";
    }

    @GetMapping("/")
    public String returnTo() {
        return "redirect:students-management/get-all-students";
    }
}
