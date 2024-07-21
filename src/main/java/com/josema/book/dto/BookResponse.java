package com.josema.book.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record BookResponse(
  @Schema(example = "200", type = "number") Integer code, 
  @Schema(example = "Book Accepted") String message) {
}
