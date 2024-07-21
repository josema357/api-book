package com.josema.book.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record ErrorResponse(
  @Schema(example = "400", type = "number") Integer statusCode, 
  @Schema(example = "Bad Request") String error, 
  @Schema(example = "required property 'houseId'") String message) {
}
