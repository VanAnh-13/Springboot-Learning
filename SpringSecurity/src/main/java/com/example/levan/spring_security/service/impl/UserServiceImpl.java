package com.example.levan.spring_security.service.impl;

import com.example.levan.spring_security.domain.dto.request.UserCreateDTO;
import com.example.levan.spring_security.domain.dto.response.UserDTO;
import com.example.levan.spring_security.domain.entity.User;
import com.example.levan.spring_security.domain.mapper.UserMapper;
import com.example.levan.spring_security.repository.UserRepository;
import com.example.levan.spring_security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;


    @Override
    public UserDTO createUser(UserCreateDTO userCreateDTO) {
        if (userRepository.findByUsername(userCreateDTO.username()).isPresent()) {
            throw new RuntimeException("User is already taken !");
        }

        User user = userMapper.toUser(userCreateDTO);
        user.setPassword(passwordEncoder.encode(userCreateDTO.password()));
        return userMapper.toUserDTO(userRepository.save(user));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userMapper.toListUserDTO(userRepository.findAll());
    }
}
