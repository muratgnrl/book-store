package com.example.stok.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDto {
    private Integer id;

    private String userName;
    private List<Integer> bookIdList;
    private Double totalPrice;

}
