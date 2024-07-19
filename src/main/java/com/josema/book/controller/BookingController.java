package com.josema.book.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josema.book.dto.BookRequest;
import com.josema.book.dto.BookResponse;
import com.josema.book.service.BookingService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/book")
@Slf4j
public class BookingController {
  private final BookingService bookingService;

  public BookingController(BookingService bookingService){
    this.bookingService = bookingService;
  }

  @PostMapping
  public ResponseEntity<BookResponse> registerBooking(@RequestBody @Valid BookRequest bookRequest){
    log.debug("Received request to endpoint");
    try {
      log.debug("Registering a new reservation");
      BookResponse response = bookingService.registerBooking(bookRequest);
      log.info("Completed request to endpoint : message : {}", response.message());
      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (Exception e) {
      log.error("Exception occurred while processing request to endpoint");
      throw e;
    }
    
  }
}
