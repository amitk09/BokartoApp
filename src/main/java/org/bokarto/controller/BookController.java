package org.bokarto.controller;

import org.bokarto.dto.BookDTO;
import org.bokarto.model.Book;
import org.bokarto.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookDTO> getAllBooks() {
        // Convert entities to DTOs for API response
        List<Book> books = bookService.getAllBooks();
        return books.stream()
                .map(BookDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BookDTO getBookDetails(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        return BookDTO.fromEntity(book);
    }
}
