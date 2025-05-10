package com.example.levan.test.service;

import com.example.levan.test.dto.AuthorDTO;

import java.util.List;

public interface AuthorService {
    AuthorDTO createAuthor(AuthorDTO authorInput);

    AuthorDTO editAuthor(Long id, AuthorDTO authorInput);

    void deleteAuthor(Long id);

    List<AuthorDTO> getAllAuthor();
}
