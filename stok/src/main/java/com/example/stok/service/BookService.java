package com.example.stok.service;

import com.example.stok.dto.BookDto;
import com.example.stok.mapper.BookMapper;
import com.example.stok.model.Book;
import com.example.stok.repository.BookRepository;
import com.example.stok.response.BookResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;


    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public List<BookDto> getAllBooks() {

        List<BookDto> bookResponseList= new ArrayList<>();
        Iterable<Book> books=bookRepository.findAll();
        for (Book book : books){
            BookDto bookDto=bookMapper.toResource(book);
            bookResponseList.add(bookDto);
        }
        return bookResponseList;
    }

    public Optional<Book> findBookById(Integer bookId) {
        return bookRepository.findById(bookId);
    }


}
