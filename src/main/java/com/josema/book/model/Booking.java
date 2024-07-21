package com.josema.book.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import com.josema.book.dto.BookRequest;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "book_id")
  private Long bookingId;

  @Column(nullable = false, length = 10)
  private String id;
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
  private String houseId;
  @Column(name = "discount_code", length = 8)
  private String discountCode;

  public Booking(String id, String name, String lastname, Integer age, String phoneNumber, LocalDate startDate,
      LocalDate endDate, String houseId) {
    this.id = id;
    this.name = name;
    this.lastname = lastname;
    this.age = age;
    this.phoneNumber = phoneNumber;
    this.startDate = startDate;
    this.endDate = endDate;
    this.houseId = houseId;
  }

  public Booking(BookRequest bookRequest) {
    this.id = bookRequest.id();
    this.name = bookRequest.name();
    this.lastname = bookRequest.lastname();
    this.age = bookRequest.age();
    this.phoneNumber = bookRequest.phoneNumber();
    this.startDate = bookRequest.startDate();
    this.endDate = bookRequest.endDate();
    this.houseId = bookRequest.houseId();
    this.discountCode = bookRequest.discountCode();
  }
}
