package com.example.stok.service;

import com.example.stok.dto.BookDto;
import com.example.stok.dto.OrderDto;
import com.example.stok.mapper.OrderMapper;
import com.example.stok.model.Book;
import com.example.stok.model.Order;
import com.example.stok.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final BookService bookService;

    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper, BookService bookService) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.bookService = bookService;
    }

    public List<OrderDto> getAllOrders() {

        List<OrderDto> orderDtoList=new ArrayList<>();
        Iterable<Order> orders=orderRepository.findAll();
        for (Order order: orders){

            OrderDto orderDto=orderMapper.toResource(order);
            orderDtoList.add(orderDto);
        }
        return orderDtoList;
    }


    public OrderDto putAnOrder(List<Integer> bookIdList, String userName) {

        //Kitapları bul

        List<Optional<Book>> bookList = new ArrayList<>();
        for (Integer bookId : bookIdList) {
            bookList.add(bookService.findBookById(bookId));
        }
        // Toplam fiyatı hesapla
        Double totalPrice = 0.0;
        for (Optional<Book> optionalBook : bookList) {
            if (optionalBook.isPresent()) {
                totalPrice += optionalBook.get().getPrice();
            }
        }
        OrderDto orderDto = new OrderDto();
        orderDto.setBookIdList(bookIdList);
        orderDto.setTotalPrice(totalPrice);
        orderDto.setUserName(userName);

        return orderDto;
    }

}

