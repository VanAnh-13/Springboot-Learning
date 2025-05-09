package com.example.levan.practice.mapper;

import com.example.levan.practice.dto.UserDTO;
import com.example.levan.practice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "createAt", target = "create_at")
    UserDTO toUserDTO(User user);

    @Mapping(source = "create_at", target = "createAt")
    User toUser(UserDTO userDTO);

    List<UserDTO> toListUserDTO(List<User> users);
}
