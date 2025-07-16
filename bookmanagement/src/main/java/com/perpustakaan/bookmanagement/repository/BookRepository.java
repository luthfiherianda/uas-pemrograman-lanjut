package com.perpustakaan.bookmanagement.repository;

import com.perpustakaan.bookmanagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
