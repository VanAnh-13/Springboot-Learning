package com.example.levan.practice.service;

import com.example.levan.practice.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userCreate);

    List<UserDTO> getAllUser();

    UserDTO updateUser(Long userId, UserDTO userUpdate);

    Void deleteUser(Long userId);
}
