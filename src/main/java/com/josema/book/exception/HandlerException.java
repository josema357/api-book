package com.josema.book.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import com.josema.book.dto.ErrorResponse;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class HandlerException {
  
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex){
    log.error("Validation failed for request : {}", ex.getBindingResult().getTarget());
    List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
    String firstError = "Validation error";

    if(!allErrors.isEmpty()){
      firstError = allErrors.get(0).getDefaultMessage();
    }

    ErrorResponse errorResponse = new ErrorResponse(400, "Bad Request", firstError);
    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
  }
}
