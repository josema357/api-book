package com.josema.book.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
public class Book {
  @Id
  @Column(nullable = false)
  private Long id;
  @Column(nullable = false, length = 50)
  private String name;
  @Column(nullable = false, length = 50)
  private String lastname;
  @Column(nullable = false)
  private Integer age;
  @Column(name = "phone_number", length = 20)
  private String phoneNumber;
  @Column(name = "start_date", columnDefinition = "DATE")
  private LocalDate startDate;
  @Column(name = "end_date", columnDefinition = "DATE")
  private LocalDate endDate;
  @Column(name = "house_id", nullable = false)
  private Long houseId;
  @Column(name = "discount_code", length = 50)
  private String discountCode;
}
