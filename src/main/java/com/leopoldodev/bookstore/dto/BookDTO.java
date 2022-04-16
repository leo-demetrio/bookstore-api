package com.leopoldodev.bookstore.dto;

import com.leopoldodev.bookstore.domain.Book;
import lombok.Data;

import java.io.Serializable;

@Data
public class BookDTO implements Serializable {

    private  static final Long serialVersionUID = 1L;

    private Integer id;
    private String title;

    public BookDTO(Book book){
        this.id = book.getId();
        this.title = book.getTitle();
    }
}
