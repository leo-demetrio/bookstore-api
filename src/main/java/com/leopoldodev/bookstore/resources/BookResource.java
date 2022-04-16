package com.leopoldodev.bookstore.resources;


import com.leopoldodev.bookstore.domain.Book;
import com.leopoldodev.bookstore.dto.BookDTO;
import com.leopoldodev.bookstore.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/books")
@RequiredArgsConstructor
public class BookResource {

    private final BookService bookService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(bookService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> findAll(@RequestParam(value = "category", defaultValue = "0") Integer id_category){
        List<Book> list = bookService.findAll(id_category);
        List<BookDTO> listDTO = list.stream().map(obj -> new BookDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestParam(value = "category", defaultValue = "0") Integer id_category,
                                       @RequestBody Book book){
        Book obj = bookService.create(book, id_category);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("books/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<BookDTO> update(@PathVariable Integer id, @RequestBody Book book){
        Book bookUpdate = bookService.update(id, book);
        return ResponseEntity.ok().body(new BookDTO(bookUpdate));
    }
    @PatchMapping(value = "/{id}")
    public ResponseEntity<BookDTO> updatePatch(@PathVariable Integer id, @RequestBody Book book){
        Book bookUpdate = bookService.update(id, book);
        return ResponseEntity.ok().body(new BookDTO(bookUpdate));
    }
    @DeleteMapping(value = "/{id}")
    public  ResponseEntity<Void> delete(@PathVariable Integer id){
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
