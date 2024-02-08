package com.example.stok.dto;

import lombok.Data;

@Data
public class BookDto {
    private Integer id;
    private String name;
    private String author;
    private Double price;
    private Integer stock;
}
