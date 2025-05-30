package com.example.levan.spring_security.service;

import com.example.levan.spring_security.domain.dto.request.UserCreateDTO;
import com.example.levan.spring_security.domain.dto.response.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserCreateDTO userCreateDTO);

    List<UserDTO> getAllUsers();
}
