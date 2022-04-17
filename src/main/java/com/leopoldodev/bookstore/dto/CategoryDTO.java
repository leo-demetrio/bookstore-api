package com.leopoldodev.bookstore.dto;


import com.leopoldodev.bookstore.domain.Category;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class CategoryDTO implements Serializable {

    private  static final Long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Required name")
    @Length(min = 3, max = 20,message = "Field with min 3 characters and max 15 characters")
    private String name;

    @NotEmpty(message = "Required name")
    @Length(min = 3, max = 200,message = "Field with min 15 characters and max 200 characters")
    private String description;


    public CategoryDTO(Category obj){
        this.id = obj.getId();
        this.name = obj.getName();
        this.description = obj.getDescription();
    }
}
