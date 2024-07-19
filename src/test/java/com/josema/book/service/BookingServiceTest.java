package com.josema.book.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import com.josema.book.dto.BookRequest;
import com.josema.book.dto.BookResponse;

@SpringBootTest
@ActiveProfiles("test")
public class BookingServiceTest {
  @Autowired
  private BookingService bookingService;

  BookRequest bookRequest;

  @BeforeEach
  void setUp(){
    bookRequest = new BookRequest(
      "14564088-4",
      "Gonzalo",
      "Pérez",
      33,
      "56988123222",
      LocalDate.of(2023, 7, 1),
      LocalDate.of(2023, 7, 15),
      "213132",
      "D0542A23"
    );

  }

  @Test
  public void registerBookingAndReturnBookResponse() {
    BookResponse response = bookingService.registerBooking(bookRequest);

    assertEquals(200, response.code());
    assertEquals("Book Accepted", response.message());
  }

}
