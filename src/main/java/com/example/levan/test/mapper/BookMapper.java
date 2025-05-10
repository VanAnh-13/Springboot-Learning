package com.example.levan.test.mapper;

import com.example.levan.test.dto.BookDTO;
import com.example.levan.test.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Book toBookEntity(BookDTO bookDTO);

    BookDTO toBookDTO(Book book);

    List<BookDTO> toListBookDTO(List<Book> books);
}
