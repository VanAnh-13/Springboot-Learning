package com.example.levan.test.mapper;

import com.example.levan.test.dto.AuthorDTO;
import com.example.levan.test.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    Author toAuthorEntity(AuthorDTO authorDTO);

    AuthorDTO toAuthorDTO(Author author);

    List<AuthorDTO> toListAuthorDTO(List<Author> authors);
}
