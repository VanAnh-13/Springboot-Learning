package com.example.levan.practice.service.impl;

import com.example.levan.practice.dto.UserDTO;
import com.example.levan.practice.entity.User;
import com.example.levan.practice.exception.ResourceNotFoundException;
import com.example.levan.practice.mapper.UserMapper;
import com.example.levan.practice.repository.UserRepository;
import com.example.levan.practice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDTO createUser(UserDTO userCreate) {
        User resultReturn = userRepository.save(userMapper.toUser(userCreate));
        return userMapper.toUserDTO(resultReturn);
    }

    @Override
    public List<UserDTO> getAllUser() {
        return userMapper.toListUserDTO(userRepository.findAll());
    }

    @Override
    public UserDTO updateUser(Long userId, UserDTO userUpdate) {
        User userExist = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("An user is not found !"));

        userExist.setCreateAt(userUpdate.create_at());
        userExist.setEmail(userUpdate.email());
        userExist.setPassword(userUpdate.password());
        userExist.setUsername(userUpdate.username());

        return userMapper.toUserDTO(userRepository.save(userExist));
    }

    @Override
    public Void deleteUser(Long userId) {
        return null;
    }
}
