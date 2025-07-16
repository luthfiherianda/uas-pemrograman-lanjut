package com.perpustakaan.bookmanagement.controller;

import com.perpustakaan.bookmanagement.model.Book;
import com.perpustakaan.bookmanagement.service.BookService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    public Book addBook(@Valid @RequestBody Book book) {
        return service.save(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return service.findAll();
    }
}
