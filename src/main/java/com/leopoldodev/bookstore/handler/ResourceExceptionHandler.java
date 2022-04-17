package com.leopoldodev.bookstore.handler;

import com.leopoldodev.bookstore.exceptions.DataIntegrityViolationException;
import com.leopoldodev.bookstore.exceptions.ObjectNotFoundException;
import com.leopoldodev.bookstore.exceptions.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException err, ServletRequest request){
        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), err.getMessage());
        return ResponseEntity.status(error.getStatus()).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> objectNotFoundException(DataIntegrityViolationException err, ServletRequest request){
        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), err.getMessage());
        return ResponseEntity.status(error.getStatus()).body(error);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validationErrors(MethodArgumentNotValidException err, ServletRequest request){
        ValidationError error = new ValidationError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Error validation fields");
        for(FieldError fieldError : err.getBindingResult().getFieldErrors())
            error.addError(fieldError.getField(), fieldError.getDefaultMessage());
        return ResponseEntity.status(error.getStatus()).body(error);
    }
}
