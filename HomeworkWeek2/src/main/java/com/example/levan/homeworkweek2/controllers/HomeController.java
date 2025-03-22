package com.example.levan.homeworkweek2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String goToHome() {
        return "redirect:/employees/get-all-employees";
    }

    @GetMapping("/home")
    public String home() {
        return "redirect:/employees/get-all-employees";
    }
}