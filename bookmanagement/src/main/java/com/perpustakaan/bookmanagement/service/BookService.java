package com.perpustakaan.bookmanagement.service;

import com.perpustakaan.bookmanagement.model.Book;
import com.perpustakaan.bookmanagement.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Book save(Book book) {
        return repository.save(book);
    }

    public List<Book> findAll() {
        return repository.findAll();
    }
}
