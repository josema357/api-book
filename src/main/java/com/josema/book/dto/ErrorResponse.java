package com.josema.book.dto;

public record ErrorResponse(
  Integer statusCode, 
  String error, 
  String message) {
}
