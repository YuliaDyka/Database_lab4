package com.api.controller;

import com.api.domain.Book;

import java.util.Optional;

public interface BookController extends GeneralController<Book, Integer> {
    Optional<Book> findByBookName(String bookName);

    Optional<Book> findByAuthor(String author);
}
