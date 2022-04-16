package com.leopoldodev.bookstore.dto;


import com.leopoldodev.bookstore.domain.Category;
import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryDTO implements Serializable {

    private  static final Long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String description;

    public CategoryDTO(Category obj){
        this.id = obj.getId();
        this.name = obj.getName();
        this.description = obj.getDescription();
    }
}
