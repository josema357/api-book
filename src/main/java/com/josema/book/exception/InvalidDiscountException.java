package com.josema.book.exception;

public class InvalidDiscountException extends RuntimeException{
  public InvalidDiscountException(String message){
    super(message);
  }
}
