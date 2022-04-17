package com.leopoldodev.bookstore.services;

import com.leopoldodev.bookstore.domain.Book;
import com.leopoldodev.bookstore.domain.Category;
import com.leopoldodev.bookstore.exceptions.ObjectNotFoundException;
import com.leopoldodev.bookstore.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final CategoryService categoryService;

    public final Book findById(Integer id){
        Optional<Book> obj = bookRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Book not found id: " + id));
    }
    public List<Book> findAll(Integer id_category){
        categoryService.findById(id_category);
        return bookRepository.findAllByCategory(id_category);
    }
    public Book create(Book book, Integer id_category){
        Category category = categoryService.findById(id_category);
        book.setId(null);
        book.setCategory(category);
        return bookRepository.save(book);
    }
    public Book update(Integer id, Book book){
        Book bookBank = findById(id);
        bookBank.setTitle(book.getTitle());
        bookBank.setName_author(book.getName_author());
        bookBank.setText(book.getText());
        return bookRepository.save(bookBank);
    }
    public void delete(Integer id){
            bookRepository.delete(findById(id));
    }
}
