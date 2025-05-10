package com.example.levan.test.service.impl;

import com.example.levan.test.dto.BookDTO;
import com.example.levan.test.entity.Author;
import com.example.levan.test.entity.Book;
import com.example.levan.test.entity.Category;
import com.example.levan.test.exception.ResourceNotFoundException;
import com.example.levan.test.mapper.BookMapper;
import com.example.levan.test.repository.AuthorRepository;
import com.example.levan.test.repository.BookRepository;
import com.example.levan.test.repository.CategoryRepository;
import com.example.levan.test.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDTO createBook(BookDTO bookInput) {
        Book book = bookMapper.toBookEntity(bookInput);
        return bookMapper.toBookDTO(bookRepository.save(book));
    }

    @Override
    public BookDTO editBook(Long id, BookDTO bookInput) {
        Book bookExist = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book id is not exist !"));

        bookExist.setName(bookInput.name());
        bookExist.setDescription(bookInput.description());
        bookExist.setPrice(bookInput.price());

        Author authorEdit = authorRepository.findById(bookInput.author_id())
                .orElseThrow(() -> new ResourceNotFoundException("Author id is not exist !"));
        bookExist.setAuthor_id(authorEdit);

        Category categoryEdit = categoryRepository.findById(bookInput.category_id())
                .orElseThrow(() -> new ResourceNotFoundException("Category id is not exist !"));
        bookExist.setCategory_id(categoryEdit);

        return bookMapper.toBookDTO(bookRepository.save(bookExist));
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public BookDTO fitterBook(String name, Double price, String nameAuthor, String nameCategory) {
        List<Book> bookDTOS = bookRepository.findAll();
        if (name == null) {

        }

        return null;
    }
}
