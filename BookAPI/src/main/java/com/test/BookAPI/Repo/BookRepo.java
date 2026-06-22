package com.test.BookAPI.Repo;
import com.test.BookAPI.Entity.Book;
import java.util.List;

public interface BookRepo {

    List<Book> getAllBooks();

    Book save(Book book);

    Book findById(Long id);

    void update(Long id, Book book);

    Book delete(Long id);

}
