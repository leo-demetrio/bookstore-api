package com.leopoldodev.bookstore.config;


import com.leopoldodev.bookstore.domain.Book;
import com.leopoldodev.bookstore.domain.Category;
import com.leopoldodev.bookstore.repositories.BookRepository;
import com.leopoldodev.bookstore.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Log4j2
@RequiredArgsConstructor
@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner {


    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        Category c1 = new Category(null, "books", "books programing");
        Book b1 = new Book(null, "Java", "Deitel", "Java with programing", c1);

        log.info(categoryRepository.saveAll(Arrays.asList(c1)));
        bookRepository.saveAll(Arrays.asList(b1));
    }
}
