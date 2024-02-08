package com.example.stok.mapper;

import com.example.stok.dto.OrderDto;
import com.example.stok.model.Order;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-08T12:57:31+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderDto toResource(Order e) {
        if ( e == null ) {
            return null;
        }

        OrderDto orderDto = new OrderDto();

        return orderDto;
    }

    @Override
    public Order toEntity(OrderDto r) {
        if ( r == null ) {
            return null;
        }

        Order order = new Order();

        return order;
    }

    @Override
    public List<OrderDto> toResourse(List<Order> eList) {
        if ( eList == null ) {
            return null;
        }

        List<OrderDto> list = new ArrayList<OrderDto>( eList.size() );
        for ( Order order : eList ) {
            list.add( toResource( order ) );
        }

        return list;
    }

    @Override
    public List<Order> toEntity(List<OrderDto> rList) {
        if ( rList == null ) {
            return null;
        }

        List<Order> list = new ArrayList<Order>( rList.size() );
        for ( OrderDto orderDto : rList ) {
            list.add( toEntity( orderDto ) );
        }

        return list;
    }
}
