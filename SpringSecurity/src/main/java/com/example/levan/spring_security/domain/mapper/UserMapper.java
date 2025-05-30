package com.example.levan.spring_security.domain.mapper;

import com.example.levan.spring_security.domain.dto.request.UserCreateDTO;
import com.example.levan.spring_security.domain.dto.response.UserDTO;
import com.example.levan.spring_security.domain.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreateDTO userCreateDTO);

    UserDTO toUserDTO(User user);

    List<UserDTO> toListUserDTO(List<User> users);
}
