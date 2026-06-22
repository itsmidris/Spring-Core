package com.test.BookAPI.Service;

import com.test.BookAPI.Entity.Book;
import com.test.BookAPI.Repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo bookRepo;

    @Override
    public List<Book> getAllBooks() {
        return bookRepo.getAllBooks();
    }

    @Override
    public Book createBook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepo.findById(id);
    }

    @Override
    public void updateBook(Long id, Book book) {
        bookRepo.update(id, book);
    }

    @Override
    public Book updatePrice(Long id, Double price) {

        Book book = bookRepo.findById(id);

        if (book != null) {
            book.setPrice(price);
            bookRepo.update(id, book);
        }

        return book;
    }

    @Override
    public Book deleteBook(Long id) {
        return bookRepo.delete(id);
    }
}