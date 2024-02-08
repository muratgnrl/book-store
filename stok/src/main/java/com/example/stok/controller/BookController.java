package com.example.stok.controller;

import com.example.stok.dto.BookDto;
import com.example.stok.dto.BookOrderRequest;
import com.example.stok.dto.OrderDto;
import com.example.stok.model.Book;
import com.example.stok.service.BookService;
import com.example.stok.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookstore")
public class BookController {

    private final BookService bookService;
    private final OrderService orderService;

    public BookController(BookService bookService, OrderService orderService) {
        this.bookService = bookService;
        this.orderService = orderService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookDto>> getAllBooks(){
        List<BookDto> books=bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }
    @PostMapping("/putAnOrder")
    public ResponseEntity<OrderDto> putAnOrder(@RequestBody BookOrderRequest bookOrderRequest) {
        OrderDto orderDto = orderService.putAnOrder(bookOrderRequest.getBookIdList(), bookOrderRequest.getUserName());

        return ResponseEntity.ok(orderDto);
    }
    @GetMapping("/find/{bookId}")
    public Optional<Book> findBookById(Integer bookId) {
        return bookService.findBookById(bookId);
    }


}
