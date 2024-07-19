package com.josema.book.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
  @Column(nullable = false, length = 10, unique = true)
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

  public static Booking fromBookRequest(BookRequest bookRequest) {
        return new Booking(
                bookRequest.id(),
                bookRequest.name(),
                bookRequest.lastname(),
                bookRequest.age(),
                bookRequest.phoneNumber(),
                bookRequest.startDate(),
                bookRequest.endDate(),
                bookRequest.houseId(),
                bookRequest.discountCode()
        );
    }
}
