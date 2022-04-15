package com.leopoldodev.bookstore.repositories;

import com.leopoldodev.bookstore.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
