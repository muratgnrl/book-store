package com.example.stok.response;

import com.example.stok.dto.OrderDto;

import java.io.Serializable;

public class OrderResponse  extends BaseResponse implements Serializable  {
   public OrderDto order;
}
