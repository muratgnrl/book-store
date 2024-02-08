package com.example.stok.mapper;

import com.example.stok.dto.BookDto;
import com.example.stok.model.Book;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface BookMapper extends IEntityMapper<BookDto, Book>{
}
