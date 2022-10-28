package com.api.domain.service;

import com.api.domain.Book;

import java.util.Optional;

public interface BookService extends GeneralService<Book, Integer> {
    Optional<Book> findByBookName(String bookName);

    Optional<Book> findByAuthor(String author);
}
