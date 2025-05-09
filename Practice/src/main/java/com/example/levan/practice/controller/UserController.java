package com.example.levan.practice.controller;

import com.example.levan.practice.dto.UserDTO;
import com.example.levan.practice.response.ApiResponse;
import com.example.levan.practice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@Validated
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ApiResponse<UserDTO> createUser(@Valid @RequestBody UserDTO userCreate) {
        UserDTO response = userService.createUser(userCreate);
        return new ApiResponse<>(HttpStatus.CREATED.value(), "User created successfully", response);
    }

    @GetMapping
    public ApiResponse<List<UserDTO>> getAllUser() {
        List<UserDTO> userDTOS = userService.getAllUser();
        return new ApiResponse<>(HttpStatus.OK.value(), "User retrieved successfully", userDTOS);
    }

    @PutMapping("/{id}")
    public ApiResponse<UserDTO> updateUser(@PathVariable(name = "id") Long userId, @Valid @RequestBody UserDTO userUpdate) {
        UserDTO userUpdated = userService.updateUser(userId, userUpdate);
        return new ApiResponse<>(HttpStatus.OK.value(), "User updated successfully", userUpdated);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteUser(@PathVariable(name = "id") Long userId) {
        userService.deleteUser(userId);
        return new ApiResponse<>(HttpStatus.OK.value(), "User deleted successfully", null);
    }
}
