package com.leopoldodev.bookstore.repositories;

import com.leopoldodev.bookstore.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("SELECT obj FROM Book obj WHERE obj.category.id = :id_category ORDER BY title")
    List<Book> findAllByCategory(@Param(value = "id_category") Integer id_category);
}
