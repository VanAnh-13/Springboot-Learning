package com.example.levan.test.controller;

import com.example.levan.test.dto.BookDTO;
import com.example.levan.test.response.ApiResponse;
import com.example.levan.test.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping
    public ApiResponse<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
        BookDTO bookCreated = bookService.createBook(bookDTO);

        return new ApiResponse<>(HttpStatus.OK.value(), "Book created successfully", bookCreated);
    }

    @PutMapping("/{id}")
    public ApiResponse<BookDTO> editBook(@PathVariable(name = "id") Long employeeId, @RequestBody BookDTO bookEdit) {
        BookDTO bookEdited = bookService.editBook(employeeId, bookEdit);
        return new ApiResponse<>(HttpStatus.OK.value(), "Book edited successfully", bookEdited);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteBook(@PathVariable(name = "id") Long employeeId) {
        bookService.deleteBook(employeeId);
        return new ApiResponse<>(HttpStatus.OK.value(), "Book edited successfully", null);
    }
}
