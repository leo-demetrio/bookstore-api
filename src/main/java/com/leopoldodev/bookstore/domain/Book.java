package com.leopoldodev.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book implements Serializable {

    private  static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String name_author;
    private String text;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
