package org.bokarto.service;

import org.bokarto.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();
    Book getBookById(Long id);
}
