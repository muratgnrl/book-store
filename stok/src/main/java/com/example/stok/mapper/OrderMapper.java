package com.example.stok.mapper;

import com.example.stok.dto.OrderDto;
import com.example.stok.model.Order;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface OrderMapper extends IEntityMapper<OrderDto, Order>{
}
