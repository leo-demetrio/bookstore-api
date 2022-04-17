package com.leopoldodev.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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

    @NotEmpty(message = "Required name")
    @Length(min = 3, max = 20,message = "Field with min 3 characters and max 15 characters")
    private String title;

    @NotEmpty(message = "Required name")
    @Length(min = 3, max = 60,message = "Field with min 3 characters and max 15 characters")
    private String name_author;

    @NotEmpty(message = "Required name")
    @Length(min = 3, max = 200,message = "Field with min 3 characters and max 200 characters")
    private String text;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
