package com.josema.book.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DiscountRequest(
  @NotBlank(message = "required property 'userId'") @Size(min = 9, max = 10) String userId,
  @NotBlank(message = "required property 'houseId'") @Size(min = 6, max = 15) String houseId,
  @NotBlank(message = "required property 'discountCode'") @Size(min = 8, max = 8) String discountCode
) {
  
}
