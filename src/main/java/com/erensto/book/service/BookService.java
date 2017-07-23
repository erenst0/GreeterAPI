package com.erensto.book.service;

import com.erensto.book.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * Created by Ernesto on 2017-07-07.
 */
public interface BookService {

    Book save(Book book);

    void delete(Book book);

    Book findOne(String id);

    Iterable<Book> findAll();

    Page<Book> findByAuthor (String author, PageRequest pageRequest);

    List<Book> findByTitle(String title);
}
