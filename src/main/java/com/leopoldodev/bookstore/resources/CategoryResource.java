package com.leopoldodev.bookstore.resources;


import com.leopoldodev.bookstore.domain.Category;
import com.leopoldodev.bookstore.dto.CategoryDTO;
import com.leopoldodev.bookstore.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/v1/categories")
@RequiredArgsConstructor
public class CategoryResource {

    private final CategoryService categoryService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(categoryService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll(){
        List<Category> list = categoryService.findAll();
        List<CategoryDTO> listDTO =
                list.stream().map(obj -> new CategoryDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<Category> create(@Valid @RequestBody Category category){
        Category obj = categoryService.create(category);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoryDTO> update(@PathVariable Integer id, @Valid @RequestBody Category category){
        Category categoryUpdate = categoryService.update(id, category);
        return ResponseEntity.ok().body(new CategoryDTO(categoryUpdate));
    }
    @DeleteMapping(value = "/{id}")
    public  ResponseEntity<Void> delete(@PathVariable Integer id){
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
