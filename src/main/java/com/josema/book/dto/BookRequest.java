package com.josema.book.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record BookRequest(
  @NotBlank(message = "required property 'id'") @Size(min = 9, max = 10) String id,
  @NotBlank(message = "required property 'name'") @Size(min = 2, max = 50) String name,
  @NotBlank(message = "required property 'lastname'") @Size(min = 2, max = 50) String lastname,
  @NotNull(message = "required property 'age'") @Min(value = 18) @Max(value = 100) Integer age,
  @NotBlank(message = "required property 'phoneNumber'") @Size(min = 9, max = 20) String phoneNumber,
  @NotNull(message = "required property 'startDate'") LocalDate startDate,
  @NotNull(message = "required property 'endDate'") LocalDate endDate,
  @NotBlank(message = "required property 'houseId'") @Size(min = 6, max = 15) String houseId,
  @Size(min = 8, max = 8) String discountCode) {
  
}
