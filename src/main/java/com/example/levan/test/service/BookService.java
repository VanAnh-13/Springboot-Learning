package com.example.levan.test.service;

import com.example.levan.test.dto.BookDTO;

public interface BookService {
    BookDTO createBook(BookDTO bookInput);

    BookDTO editBook(Long id, BookDTO bookInput);

    void deleteBook(Long bookId);

    BookDTO fitterBook(String name, Double price, String nameAuthor, String nameCategory);
}
