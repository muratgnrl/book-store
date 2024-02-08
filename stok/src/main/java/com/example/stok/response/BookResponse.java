package com.example.stok.response;

import com.example.stok.dto.BookDto;

import java.io.Serializable;

public class BookResponse extends BaseResponse implements Serializable {
    public BookDto book;
}
