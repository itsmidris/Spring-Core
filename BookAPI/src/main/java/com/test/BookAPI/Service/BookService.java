package com.test.BookAPI.Service;

import com.test.BookAPI.Entity.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book createBook(Book book);

    Book getBookById(Long id);

    void updateBook(Long id, Book book);

    Book updatePrice(Long id, Double price);

    Book deleteBook(Long id);
}