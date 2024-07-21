package com.josema.book.dto;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record BookRequest(
  @NotBlank(message = "required property 'id'") @Size(min = 9, max = 10) @Schema(example = "14564088-4") String id,
  @NotBlank(message = "required property 'name'") @Size(min = 2, max = 50) @Schema(example = "Gonzalo") String name,
  @NotBlank(message = "required property 'lastname'") @Size(min = 2, max = 50) @Schema(example = "Pérez") String lastname,
  @NotNull(message = "required property 'age'") @Min(value = 18) @Max(value = 100) @Schema(example = "33", type = "number") Integer age,
  @NotBlank(message = "required property 'phoneNumber'") @Size(min = 9, max = 20) @Schema(example = "56988123222") String phoneNumber,
  @NotNull(message = "required property 'startDate'") LocalDate startDate,
  @NotNull(message = "required property 'endDate'") LocalDate endDate,
  @NotBlank(message = "required property 'houseId'") @Size(min = 6, max = 15) @Schema(example = "213132") String houseId,
  @Size(min = 8, max = 8) @Schema(example = "D0542A23") String discountCode) {
  
}
