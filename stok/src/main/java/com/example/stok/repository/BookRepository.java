package com.example.stok.repository;

import com.example.stok.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
    Book findBookById(int id);
}
