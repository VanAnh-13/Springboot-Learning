package com.example.levan.test.service.impl;

import com.example.levan.test.dto.AuthorDTO;
import com.example.levan.test.entity.Author;
import com.example.levan.test.exception.ResourceNotFoundException;
import com.example.levan.test.mapper.AuthorMapper;
import com.example.levan.test.repository.AuthorRepository;
import com.example.levan.test.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public AuthorDTO createAuthor(AuthorDTO authorInput) {
        Author author = authorMapper.toAuthorEntity(authorInput);
        return authorMapper.toAuthorDTO(authorRepository.save(author));
    }

    @Override
    public AuthorDTO editAuthor(Long id, AuthorDTO authorInput) {
        Author authorExist = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author is not exists"));

        authorExist.setBio(authorInput.bio());
        authorExist.setName(authorInput.name());
        authorExist.setDoB(authorInput.doB());

        return authorMapper.toAuthorDTO(authorRepository.save(authorExist));
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public List<AuthorDTO> getAllAuthor() {
        return authorMapper.toListAuthorDTO(authorRepository.findAll());
    }
}
