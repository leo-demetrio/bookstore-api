package com.leopoldodev.bookstore.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category implements Serializable {

    private  static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Required name")
    @Length(min = 3, max = 20,message = "Field name with  min 3 characters and max 15 characters")
    private String name;

    @NotEmpty(message = "Required name")
    @Length(min = 3, max = 200,message = "Field description with min 15 characters and max 200 characters")
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Book> books = new ArrayList<>();

    public Category(Integer id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }

}
