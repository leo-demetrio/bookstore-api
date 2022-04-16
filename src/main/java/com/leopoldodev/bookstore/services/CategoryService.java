package com.leopoldodev.bookstore.services;

import com.leopoldodev.bookstore.domain.Category;
import com.leopoldodev.bookstore.dto.CategoryDTO;
import com.leopoldodev.bookstore.exceptions.ObjectNotFoundException;
import com.leopoldodev.bookstore.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public final Category findById(Integer id){
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Category not found id: " + id));
    }
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }
}
