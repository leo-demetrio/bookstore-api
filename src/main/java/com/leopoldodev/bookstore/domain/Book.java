package com.leopoldodev.bookstore.domain;

import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Book {
    private Integer id;
    private String title;
    private String name_author;
    private String text;

    private Category category;

    public Book(Integer id, String title, String name_author, String text, Category category) {
        this.id = id;
        this.title = title;
        this.name_author = name_author;
        this.text = text;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName_author() {
        return name_author;
    }

    public void setName_author(String name_author) {
        this.name_author = name_author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
