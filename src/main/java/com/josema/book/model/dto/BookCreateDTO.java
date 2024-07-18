package com.josema.book.model.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record BookCreateDTO(
  @NotNull(message = "'id' cannot be null")
  Long id,

  @NotBlank(message = "'name' cannot be blank") 
  String name,

  @NotBlank(message = "'name' cannot be blank")
  String lastname,

  @NotNull(message = "'age' cannot be null")
  @Min(value = 18, message = "'age' must be greater than or equal to 18 years")
  @Positive(message = "'age' must be positive")
  Integer age,

  @NotBlank(message = "'phoneNumber' cannot be blank")
  String phoneNumber,

  @FutureOrPresent(message = "'startDate' must be future or present")
  @NotNull
  LocalDate startDate,

  @FutureOrPresent(message = "'endDate' must be future or present")
  @NotNull
  LocalDate endDate,

  @NotNull(message = "'houseId' cannot be null")
  Long houseId,

  @NotBlank(message = "'discountCode' cannot be blank")
  String discountCode) {
  
}
