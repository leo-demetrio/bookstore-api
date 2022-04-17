package com.leopoldodev.bookstore.exceptions;

import com.leopoldodev.bookstore.handler.StandardError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


import java.util.ArrayList;
import java.util.List;

@Data
public class ValidationError extends StandardError {

    private final List<FieldMessage> errors = new ArrayList<>();

    public void addError(String fieldName, String message){
        this.errors.add(new FieldMessage(fieldName,message));
    }

    public ValidationError(Long timestamp, Integer status, String error){
        super(timestamp, status, error);
    }

}
