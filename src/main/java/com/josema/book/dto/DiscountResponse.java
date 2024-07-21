package com.josema.book.dto;

public record DiscountResponse(
  String houseId,
  String discountCode,
  Integer id,
  String userId,
  Boolean status
) {
  
}
