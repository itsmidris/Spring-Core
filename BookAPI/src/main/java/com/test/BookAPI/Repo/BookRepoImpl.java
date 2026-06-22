package com.test.BookAPI.Repo;

import com.test.BookAPI.Entity.Book;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BookRepoImpl implements BookRepo {

    private Map<Long, Book> bookDB = new HashMap<>();

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(bookDB.values());
    }

    @Override
    public Book save(Book book) {
        bookDB.put(book.getId(), book);
        return book;
    }

    @Override
    public Book findById(Long id) {
        return bookDB.get(id);
    }

    @Override
    public void update(Long id, Book book) {
        bookDB.put(id, book);
    }

    @Override
    public Book delete(Long id) {
        return bookDB.remove(id);
    }
}