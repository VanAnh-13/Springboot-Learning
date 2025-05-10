package com.example.levan.test.controller;

import com.example.levan.test.dto.AuthorDTO;
import com.example.levan.test.response.ApiResponse;
import com.example.levan.test.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/author")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping
    public ApiResponse<AuthorDTO> createAuthor(@RequestBody AuthorDTO authorDTO) {
        AuthorDTO authorCreated = authorService.createAuthor(authorDTO);
        return new ApiResponse<>(HttpStatus.OK.value(), "Author created successfully", authorCreated);
    }

    @PutMapping("/{id}")
    public ApiResponse<AuthorDTO> editAuthor(@PathVariable(name = "id") Long authorId, @RequestBody AuthorDTO authorEdit) {
        AuthorDTO authorEdited = authorService.editAuthor(authorId, authorEdit);
        return new ApiResponse<>(HttpStatus.OK.value(), "Author edited successfully", authorEdited);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteAuthor(@PathVariable(name = "id") Long authorId) {
        authorService.deleteAuthor(authorId);
        return new ApiResponse<>(HttpStatus.OK.value(), "Author edited successfully", null);
    }

    @GetMapping
    public ApiResponse<List<AuthorDTO>> getAllAuthor() {
        return new ApiResponse<>(HttpStatus.OK.value(), "Author retrieved successfully", authorService.getAllAuthor());
    }
}
