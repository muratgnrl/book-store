package com.example.stok.mapper;

import com.example.stok.dto.BookDto;
import com.example.stok.model.Book;
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
public class BookMapperImpl implements BookMapper {

    @Override
    public BookDto toResource(Book e) {
        if ( e == null ) {
            return null;
        }

        BookDto bookDto = new BookDto();

        return bookDto;
    }

    @Override
    public Book toEntity(BookDto r) {
        if ( r == null ) {
            return null;
        }

        Book book = new Book();

        return book;
    }

    @Override
    public List<BookDto> toResourse(List<Book> eList) {
        if ( eList == null ) {
            return null;
        }

        List<BookDto> list = new ArrayList<BookDto>( eList.size() );
        for ( Book book : eList ) {
            list.add( toResource( book ) );
        }

        return list;
    }

    @Override
    public List<Book> toEntity(List<BookDto> rList) {
        if ( rList == null ) {
            return null;
        }

        List<Book> list = new ArrayList<Book>( rList.size() );
        for ( BookDto bookDto : rList ) {
            list.add( toEntity( bookDto ) );
        }

        return list;
    }
}
