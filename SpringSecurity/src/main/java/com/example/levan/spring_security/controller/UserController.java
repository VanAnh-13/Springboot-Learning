package com.example.levan.spring_security.controller;

import com.example.levan.spring_security.domain.dto.request.UserCreateDTO;
import com.example.levan.spring_security.domain.dto.response.ApiResponse;
import com.example.levan.spring_security.domain.dto.response.UserDTO;
import com.example.levan.spring_security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ApiResponse<UserDTO> createUser(@RequestBody UserCreateDTO userCreateDTO) {
        return new ApiResponse<>(HttpStatus.CREATED.value(), "User created successfully", userService.createUser(userCreateDTO));
    }

    @GetMapping
    public ApiResponse<List<UserDTO>> getAllUser() {
        return new ApiResponse<>(HttpStatus.ACCEPTED.value(), "User fetched successfully", userService.getAllUsers());
    }
}
